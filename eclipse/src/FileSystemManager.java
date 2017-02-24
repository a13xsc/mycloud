
public class FileSystemManager {
	
	Directory currentDirectory;
	final Directory root;
	
	private static final FileSystemManager INSTANCE = new FileSystemManager();
	
	public static final FileSystemManager getInstance() {
		return INSTANCE;
	}
	
	private FileSystemManager() {
		currentDirectory = new Directory("root","");
		root = currentDirectory;
	}
	
	void add(Repo repo) {
		currentDirectory.addChild(repo);
		repo.parent = currentDirectory;
		if(currentDirectory == root) {
			repo.path = repo.name;
		}
		else {
			repo.path = currentDirectory.path + "/" + repo.name;
		}
		System.out.println("Success");
	}
	
	void remove(Repo repo) {
		currentDirectory.removeChild(repo);
		System.out.println("Success");
	}
}
