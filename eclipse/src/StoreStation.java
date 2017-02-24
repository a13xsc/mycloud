import java.util.HashSet;

public class StoreStation {

	HashSet<Directory> storage;
	
	StoreStation() {
		storage = new HashSet<Directory>();
	}
	
	void store(Directory dir) {
		storage.clear();
		Directory copyDir = new Directory(dir);
		storage.add(copyDir);
	}
	
	Directory search(Repo repo) {
		for(Directory dir:storage) {
			if(dir.name.equals(repo.name)) {
				return dir;
			}
		}
		return null;
	}
	
}
