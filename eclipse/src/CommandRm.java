import java.util.Date;

public class CommandRm extends WriteCommand {

	String[] command;
	
	CommandRm(String[] command) {
		this.command = command;
		repo = fm.currentDirectory;
	}
	
	public void execute(Directory dir) throws MyInvalidPathException {
		if(um.currentUser.username.equals("root")) {
			run(dir);
		}
		else {
			if(checkWrite(fm.currentDirectory)) {
				run(dir);
			}
			else {
				System.out.println("You do not have the rights");
			}
		}
	}
	
	private void run(Directory dir) throws MyInvalidPathException {
		boolean found = false;
		if(command.length == 2) {
			for(int i=0;i<dir.children.size();i++) {
				Repo repo = dir.children.get(i);
				if(repo.name.matches(command[1])) {
					found = true;
					if(repo instanceof File) {
						fm.remove(repo);
					}
					else {
						if(((Directory)repo).children.isEmpty()) {
							fm.remove(repo);
						}
						else {
							System.out.println("Directory \""+repo.name+"\" is not empty. Use -r.");
						}
					}
				}
			}
		}
		else if(command.length == 3 && command[2].equals("-r")) {
			for(int i=0;i<dir.children.size();i++) {
				Repo repo = dir.children.get(i);
				if(repo.name.matches(command[1])) {
					found = true;
					fm.remove(repo);
				}
			}
		}
		if(found == false) {
			String stringCommand = new String();
			for(int i=0;i<command.length-1;i++) {
				stringCommand = stringCommand + command[i] + " ";
			}
			stringCommand += command[command.length - 1];
			throw new MyInvalidPathException(um.currentUser, new Date(), fm.currentDirectory.path, stringCommand);
		}
	}

	@Override
	public void execute(File file) {}

}
