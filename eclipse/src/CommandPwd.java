
public class CommandPwd extends ReadCommand {

	@Override
	public void execute(Repository rep) {
		rep.accept(this);
	}

	@Override
	public void execute(Directory dir) {
		if(um.currentUser.username.equals("root")) {
			System.out.println("/" + fm.currentDirectory.path);
		}
		else {
			if(checkRead(fm.currentDirectory)) {
				System.out.println("/" + fm.currentDirectory.path);
			}
			else {
				System.out.println("You do not have the rights");
			}
		}
	}

	@Override
	public void execute(File file) {}

}
