package ui;

import java.util.Scanner;

import data.IData.DALException;
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
		print(languageHandler.menuMessage, true);

		while (true) {
			int command = -1;
			do {
				print(languageHandler.commandMessage, false);
				while (!input.hasNextInt()) {
					print(languageHandler.commandMessage, false);
					input.next();
				}
				command = input.nextInt();
			} while (command == -1);

			switch (command) {
			case 0:
				print(languageHandler.quitMessage, true);
				System.exit(0);
				break;
			case 1:
				print(languageHandler.menuMessage, true);
				break;
			case 2:
				/* Hvor skal denne Exception catches? */
				try {
					createUser();
				} catch (DALException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				/* Hvor skal denne Exception catches? */
				try {
					showUsers();
				} catch (DALException e1) {
					e1.printStackTrace();
				}
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

	private void showUsers() throws DALException {
		print(logic.showUsers(), true);
	}

	@Override
	public void createUser() throws DALException {
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
			print(languageHandler.enterPasswordMessage, false);
			password = input.nextLine();
		} while (!logic.verifyPassword(password));

		String ini;
		do {
			print(languageHandler.enterIniMessage, false);
			ini = input.nextLine();
		} while (ini == null);

		String role;
		do {
			print(languageHandler.enterRoleMessage, false);
			role = input.nextLine();
		} while (role == null);

		logic.createUser(userId, cpr, userName, password, ini, role);
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