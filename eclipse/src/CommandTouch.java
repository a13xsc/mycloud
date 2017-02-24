
public class CommandTouch extends WriteCommand {

	Rights rights;
	
	CommandTouch(String[] command) {
		repo = new File(command[1]);
		if (command.length == 4) {
			rights = new Rights(command[3], um.currentUser);
			repo.rights = rights;
			repo.size = Integer.parseInt(command[2]);
		}
		else if(command.length == 3) {
			repo.size = Integer.parseInt(command[2]);
		}
	}
	
	@Override
	public void execute(File file) {
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
	public void execute(Directory dir) {}
}
