import java.util.Date;

public class MyInvalidPathException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	User user;
	Date date;
	String currentPath;
	String command;
	
	MyInvalidPathException(User user, Date date, String currentPath, String command) {
		this.user = user;
		this.date = date;
		this.currentPath = currentPath;
		this.command = command;
	}

}
