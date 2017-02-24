
public class CommandUserInfo implements SystemCommand {

	@Override
	public void execute(Repository rep) {
		User currentUser = UserManager.getInstance().currentUser;
		System.out.println(currentUser);
	}

	@Override
	public void execute(Directory dir) {}

	@Override
	public void execute(File file) {}
}
