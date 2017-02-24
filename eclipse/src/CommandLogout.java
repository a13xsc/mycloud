
public class CommandLogout implements SystemCommand {
	
	@Override
	public void execute(Repository rep) {
		UserManager.getInstance().changeUser(UserManager.getInstance().guest);
	}

	@Override
	public void execute(Directory dir) {}

	@Override
	public void execute(File file) {}

}
