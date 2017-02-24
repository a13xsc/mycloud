
public class File extends Repo {
	
	File(){}
	
	File(String name) {
		super(name);
		size = 0;
	}
	
	File(String name, int size) {
		super(name);
		this.size = size;
	}
	
	File(File file) {
		super(file);
	}
	
	public void accept(Command com) {
		try {
			com.execute(this);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
