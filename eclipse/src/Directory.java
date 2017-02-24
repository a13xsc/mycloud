import java.util.ArrayList;

public class Directory extends Repo {
	
	ArrayList<Repo> children;
	
	Directory(String name) {
		super(name);
		children = new ArrayList<Repo>();
		size = 0;
	}
	
	Directory(String name, String path) {
		super(name);
		this.path = path;
		children = new ArrayList<Repo>();
		size = 0;
	}
	
	Directory(Directory dir) {
		super(dir);
		children = new ArrayList<Repo>();
		for(Repo repo:dir.children) {
			if(repo instanceof Directory) {
				this.addChild(new Directory((Directory)repo));
			}
			else {
				this.addChild(new File((File)repo));
			}
			updateSize();
		}
	}

	public void addChild(Repo child) {
		children.add(child);
		size += child.size;
		updateSize();
	}

	public void removeChild(Repo child) {
		children.remove(child);
		size -= child.size;
		updateSize();
	}
	
	public void accept(Command com) {
		try {
			com.execute(this);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updateSize() {
		size = 0;
		for(Repo repo: children) {
			size += repo.size;
		}
		if(parent != null) {
			parent.updateSize();
		}
	}

}
