import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		CommandManager commandManager = CommandManager.getInstance();
		
		while(!input.equals("exit")) {
			Command command = commandManager.getCommand(input);
			commandManager.runCommand(command);
			
			input = keyboard.nextLine();
		}
		
		keyboard.close();
	}

}
