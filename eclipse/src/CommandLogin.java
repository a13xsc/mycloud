
public class CommandLogin implements SystemCommand {

	User user;
	UserManager um;
	
	CommandLogin(String[] command) {
		this.user = new User(command[1],command[2]);
		um = UserManager.getInstance();
	}
	
	@Override
	public void execute(Repository rep) {
		um.changeUser(user);
	}

	@Override
	public void execute(Directory dir) {}

	@Override
	public void execute(File file) {}

}
