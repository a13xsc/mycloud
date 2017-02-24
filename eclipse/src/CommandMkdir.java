
public class CommandMkdir extends WriteCommand {

	Rights rights;
	
	CommandMkdir(String[] command) {
		repo = new Directory(command[1]);
		if (command.length == 3) {
			rights = new Rights(command[2], um.currentUser);
			repo.rights = rights;
		}
	}
	
	@Override
	public void execute(Directory dir) {
		if(um.currentUser.username.equals("root")) {
			fm.add(repo);
		}
		else {
			if(checkWrite(fm.currentDirectory)) {
				fm.add(repo);
			}
			else {
				System.out.println("You do not have the rights");
			}
		}
	}

	@Override
	public void execute(File file) {}

}
