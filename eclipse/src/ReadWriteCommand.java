
public abstract class ReadWriteCommand implements Command {

	Repo repo;
	UserManager um;
	FileSystemManager fm;
	
	ReadWriteCommand() {
		um = UserManager.getInstance();
		fm = FileSystemManager.getInstance();
		repo = fm.currentDirectory;
	}
	
	ReadWriteCommand(Repo repo) {
		um = UserManager.getInstance();
		fm = FileSystemManager.getInstance();
		this.repo = repo;
	}
	
	public void execute(Repository rep) {
		rep.accept(this);
	}
	
}
