
public abstract class ReadCommand extends ReadWriteCommand {
	
	boolean checkRead(Repo repo) {
		if(fm.currentDirectory.rights == null) {
			return true;
		}
		return fm.currentDirectory.rights.user.username.equals(um.currentUser.username) && fm.currentDirectory.rights.read == true;
	}
}
