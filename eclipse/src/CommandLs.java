
public class CommandLs extends ReadCommand{
	
	String[] command;
	
	CommandLs(String[] command) {
		this.command = command;
		repo = fm.currentDirectory;
	}
	
	@Override
	public void execute(Directory dir) {
		if(command.length == 1) {
			for(Repository rep:dir.children) {
				System.out.println(((Repo)rep).name);
			}
		}
		else if(command.length == 2) {
			if(command[1].charAt(0) != '-') {
				for(Repo repo:dir.children) {
					if(repo.name.matches(command[1])) {
						System.out.println("F: "+repo.name+" ["+repo.dateCreated+"] "+repo.size);
					}
				}
			}
			else if(command[1].contains("r")) {	
				if(command[1].contains("a")) {
					for(Repository rep:dir.children) {
						Repo repo = (Repo)rep;
						if(rep instanceof Directory) {
							System.out.println("D: "+repo.name+" ["+repo.dateCreated+"] "+repo.size);
							execute((Directory)rep);
						}
						else {
							System.out.println("F: "+repo.name+" ["+repo.dateCreated+"] "+repo.size);
						}
					}
				}
				else {
					for(Repository rep:dir.children) {
						System.out.println(((Repo)rep).name);
						if(rep instanceof Directory) {
							execute((Directory)rep);
						}
					}
				}
			}
			else if(command[1].contains("a")) {
				for(Repository rep:dir.children) {
					if(rep instanceof File) {
						File file = (File)rep;
						System.out.println("F: "+file.name+" ["+file.dateCreated+"] "+file.size);
					}
					else {
						Directory directory = (Directory)rep;
						System.out.println("D: "+directory.name+" ["+directory.dateCreated+"] "+directory.size);
					}
				}
			}
			
		}
	}

	@Override
	public void execute(File file) {}

}
