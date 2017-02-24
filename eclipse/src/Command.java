
public interface Command {
	void execute(Repository rep);
	void execute(Directory dir) throws MyInvalidPathException;
	void execute(File file) throws MyInvalidPathException;
}
