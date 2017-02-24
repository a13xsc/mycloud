
public class Rights {
	boolean read, write;
	User user;
	
	Rights(String str, User user) {
		if(str.contains("r")) {
			read = true;
		}
		if(str.contains("w")) {
			write = true;
		}
		this.user = user;
	}
	
	Rights(Rights rights) {
		this.read = rights.read;
		this.write = rights.write;
		this.user = new User(rights.user);
	}
	
	public String toString() {
		return read+" "+write+" "+user.username;
	}
}
