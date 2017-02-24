import java.util.Date;

public abstract class Repo implements Repository {
	
	String name, path;
	Rights rights;
	Directory parent;
	Date dateCreated;
	int size;
	
	Repo() {}
	
	Repo(String name) {
		this.name = name;
		dateCreated = new Date();
	}
	
	Repo(Repo repo) {
		this.name = repo.name;
		this.path = repo.path;
		this.dateCreated = repo.dateCreated;
		this.size = repo.size;
	}
	
	public String toString() {
		return name;
	}
	
}
