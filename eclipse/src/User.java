import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class User {
	String username, password, name, surname;
	Date dateCreated, lastLogged;
	
	User(String username, String password) {
		this(username, password, "", "");
	}
	
	User(String username, String password, String name, String surname) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.dateCreated = new Date();
	}
	
	User(User user) {
		this.username = user.username;
		this.password = user.password;
		this.name = user.name;
		this.surname = user.surname;
		this.dateCreated = user.dateCreated;
		this.lastLogged = user.lastLogged;
	}
	
	public String toString() {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return "UserName:" + username + " FirstName:" + name + " LastName:" + surname + " Created:" + df.format(dateCreated) + " LastLogin:" + df.format(lastLogged);
	}
}
