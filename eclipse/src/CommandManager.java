import java.util.Scanner;

public class CommandManager {
	
	private static final CommandManager INSTANCE = new CommandManager();
	
	FileSystemManager fm;
	UserManager um;
	CloudService cs;
	Scanner keyboard;
	String[] currentCommand;
	
	private CommandManager() {
		keyboard = new Scanner(System.in);
		fm = FileSystemManager.getInstance();
		um = UserManager.getInstance();
		cs = CloudService.getInstance();
	}
	
	public static final CommandManager getInstance() {
		return INSTANCE;
	}
	
	Command getCommand(String command) {
		currentCommand = command.split(" ");
		String comm = currentCommand[0];
		
		if(comm.equals("userinfo")) {
			return new CommandUserInfo();
		}
		else if(comm.equals("echo")) {
			return new CommandEcho(command);
		}
		else if(comm.equals("newuser")) {
			return new CommandNewUser(currentCommand);
		}
		else if(comm.equals("login")) {
			return new CommandLogin(currentCommand);
		}
		else if(comm.equals("logout")) {
			return new CommandLogout();
		}
		else if(comm.equals("ls")) {
			return new CommandLs(currentCommand);
		}
		else if(comm.equals("cd")) {
			return new CommandCd(currentCommand);
		}
		else if(comm.equals("pwd")) {
			return new CommandPwd();
		}
		else if(comm.equals("upload")) {
			cs.upload(fm.currentDirectory);
			System.out.println("Success");
		}
		else if(comm.equals("sync")) {
			cs.sync(fm.currentDirectory);
		}
		else if(comm.equals("mkdir")) {
			return new CommandMkdir(currentCommand);
		}
		else if(comm.equals("touch")) {
			return new CommandTouch(currentCommand);
		}
		else if(comm.equals("rm")) {
			return new CommandRm(currentCommand);
		}
		
		return null;
	}
	
	void runCommand(Command command) {
		if(command != null) {
			if(command instanceof SystemCommand) {
				command.execute((Repository)new File());
			}
			else {
				if(um.currentUser.username.equals("guest")) {
					System.out.println("You do not have permission");
				}
				else {
					command.execute(((ReadWriteCommand)command).repo);
				}
			}
		}
	}
	
}
