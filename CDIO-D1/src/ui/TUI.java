package ui;

import java.util.Scanner;

import logic.ILogic;

public class TUI implements ITUI {

	private ILogic func;
	private Scanner input = new Scanner(System.in);

	private final LanguageHandler languageHandler;
	
	
	public TUI(ILogic func) {
		this.func = func;
		this.languageHandler = LanguageHandler.getInstance();
	}

	public void dialog() {
		while (true) {
				
			System.out.println(languageHandler.menuMessage);
			
			int action = input.nextInt();
			input.nextLine();

			if (action == 1) {
				boolean done = false;
				do {
					this.showMessage("Enter id:");
					int userId = input.nextInt();
					input.nextLine();

					this.showMessage("Enter Name:");
					String userName = input.next();
					input.nextLine();

					this.showMessage("Enter Initialer:");
					String ini = input.next();
					input.nextLine();

					this.showMessage("Enter Cpr:");
					String cpr = input.next();
					input.nextLine();

					this.showMessage("Enter pass:");
					String pass = input.next();
					input.nextLine();

					this.showMessage("Enter role:");
					String role = input.next();
					input.nextLine();

					//done = func.createUser(userId, userName, ini, cpr, pass, role);
				} while (!done);

			} else if (action == 2) {

			} else {
				this.showMessage("invalid input");
			}
		}
	}

	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}

}