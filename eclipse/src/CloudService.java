import java.util.ArrayList;

public class CloudService {

	private static final CloudService INSTANCE = new CloudService();
	
	StoreStation s1,s2,s3;
	private FileSystemManager fm;
	private int storageUsed;
	private ArrayList<Repo> array;
	private CloudService() {
		s1 = new StoreStation();
		s2 = new StoreStation();
		s3 = new StoreStation();
		fm = FileSystemManager.getInstance();
		array = new ArrayList<Repo>();
	}
	
	public static final CloudService getInstance() {
		return INSTANCE;
	}
	
	void upload(Directory dir) {
		storageUsed = 0;
		s1.store(dir);
		storageUsed = dir.size;
	}
	
	void sync(Directory dir) {
		if(storageUsed < 10000) {
			fm.currentDirectory.children.clear();
			Directory backup = s1.search(dir);
			if(backup != null) {
				Directory current = new Directory(backup);
				fm.currentDirectory.children = current.children;
				System.out.println("Success");
			}
		}
	}
	
	void linearize(Directory dir) {
		array.add(dir);
		for(Repo repo:dir.children) {
			if(repo == null) {
				return;
			}
			if(repo instanceof Directory) {
				linearize((Directory)repo);
			}
			else {
				array.add(repo);
			}
		}
	}
}
