
public class CommandNewUser implements SystemCommand {

	User user;
	UserManager um;
	
	CommandNewUser(String[] command) {
		user = new User(command[1], command[2], command[3], command[4]);
		um = UserManager.getInstance();
	}
	
	@Override
	public void execute(Repository rep) {
		um.addUser(user);
		System.out.println("Success");
	}

	@Override
	public void execute(Directory dir) {}

	@Override
	public void execute(File file) {}
	
}
