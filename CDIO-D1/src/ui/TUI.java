package ui;

import java.util.Scanner;

import logic.ILogic;

public class TUI implements ITUI {

	private final ILogic logic;
	private final LanguageHandler languageHandler;
	private final Scanner input;

	public TUI(ILogic logic) {
		this.logic = logic;
		this.languageHandler = LanguageHandler.getInstance();
		input = new Scanner(System.in);
	}

	public void initTUI() {
		while (true) {
			print(languageHandler.menuMessage, true);

			print(languageHandler.commandMessage, false);
			int command = input.nextInt();

			switch (command) {
			case 0:
				print(languageHandler.quitMessage, true);
				System.exit(0);
				break;
			case 1:
				break;
			case 2:
				createUser();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				print(languageHandler.invalidCommandMessage, true);
				break;
			}
		}
	}

	@Override
	public void createUser() {
		String cpr;
		do {
			print(languageHandler.enterCprMessage, false);
			cpr = input.nextLine();
		} while (cpr == null);

		int userId = -1;
		do {
			print(languageHandler.enterUserIdMessage, false);
			userId = input.nextInt();
			input.nextLine();
		} while (userId == -1 || userId < 11 || userId > 99);

		String userName;
		do {
			print(languageHandler.enterUserNameMessage, false);
			userName = input.nextLine();
		} while (userName == null);
		
		
		String password;
		do {
			print(languageHandler.enterUserNameMessage, false);
			password = input.nextLine();
		} while (password == null );
		
		/*
		 * osv.....
		 */
	}

	@Override
	public void print(String message, boolean newLine) {
		if (newLine) {
			System.out.println(message);
		} else {
			System.out.print(message);
		}
		
		
		
	}

}