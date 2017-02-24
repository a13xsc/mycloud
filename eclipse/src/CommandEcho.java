
public class CommandEcho implements SystemCommand {

	String text;
	
	CommandEcho(String command) {
		this.text = command.split(" ", 2)[1];
	}
	
	@Override
	public void execute(Repository rep) {
		System.out.println(text);
	}

	@Override
	public void execute(Directory dir) {}

	@Override
	public void execute(File file) {}

}
