import java.util.Date;
import java.util.ArrayList;

public class UserManager {
	
	private static final UserManager INSTANCE = new UserManager();
	
	User guest, root;
	User currentUser;
	ArrayList<User> users;
	
	private UserManager() {
		users = new ArrayList<User>();
		guest = new User("guest","");
		root = new User("root","rootpass");
		currentUser = guest;
		guest.lastLogged = new Date();
	}
	
	public static final UserManager getInstance() {
		return INSTANCE;
	}
	
	void changeUser(User user) {
		if(user.username.equals("root")) {
			if(user.password.equals(root.password)) {
				currentUser = root;
				root.lastLogged = new Date();
				System.out.println("Success");
			}
			else {
				System.out.println("Incorrect password");
			}
		}
		else if(user.username.equals("guest")) {
			currentUser = guest;
			guest.lastLogged = new Date();
			System.out.println("Success");
		}
		else {
			for(User u:users) {
				if(u.username.equals(user.username)) {
					if(u.password.equals(user.password)) {
						currentUser = u;
						u.lastLogged = new Date();
						System.out.println("Success");
						return;
					}
					else {
						System.out.println("Incorrect password");
						return;
					}
				}
			}
			System.out.println("User " + user.username + " does not exist");
		}
	}
	
	void addUser(User user) {
		users.add(user);
	}
	
	void printUsers() {
		for(User user:users) {
			System.out.println(user.username);
		}
	}
}
