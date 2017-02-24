import java.util.Date;

public class CommandCd extends ReadCommand {

	String[] path;
	
	CommandCd(String[] command) {
		path = command[1].split("/");
	}
	
	
	public void execute(Directory dir) throws MyInvalidPathException {
		for(String s:path) {
			boolean found = false;
			if(s.equals("..")) {
				if(dir.parent != null) {
					dir = dir.parent;
				}
				else {
					throw new MyInvalidPathException(um.currentUser, new Date(), fm.currentDirectory.path, "cd " + path);
				}
			}
			else {
				for(Repo repo:dir.children) {
					if(repo.name.equals(s)) {
						dir = (Directory)repo;
						found = true;
						break;
					}
				}
				if(found == false) {
					dir = null;
					System.out.println("Directory does not exist");
				}
			}
		}
		if(dir != null) {
			fm.currentDirectory = dir;
			System.out.println("Success");
		}
	}

	@Override
	public void execute(File file) {}

}
