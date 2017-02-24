
public abstract class WriteCommand extends ReadWriteCommand {
	
	boolean checkWrite(Repo repo) {
		if(repo.rights == null) {
			return true;
		}
		return repo.rights.user.username.equals(um.currentUser.username) && repo.rights.write == true;
	}
}
