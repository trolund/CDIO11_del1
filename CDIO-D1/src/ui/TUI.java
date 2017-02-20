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
				try {
					updateUser();
				} catch (DALException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 5:
				try {
					deleteUser();
				} catch (DALException e) {
					e.printStackTrace();
				}
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
	public void createUser() throws DALException {
		String cpr;
		do {
			print(languageHandler.enterCprMessage, false);
			cpr = input.next();
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
		} while (userName == null || userName.length() < 1 || userName.length() < 20);

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

		print(languageHandler.userCreatedMessage(userId), true);
		logic.createUser(userId, cpr, userName, password, ini, role);
	}

	@Override
	public void updateUser() throws DALException {

		System.out.println("User id:");
		int id = input.nextInt();

		if (!logic.userExist(id)) {
			System.err.println("Brugen kunne ikke findes");
		} else {
			print(languageHandler.updateMessage, true);
			int action = input.nextInt();

			switch (action) {
			case 0:
				break;
			case 1:
				print("Indtast nyt cpr", true);
				String cpr = input.next();
				logic.updateUser(id, 1, cpr);
				break;
			case 2:
				print("Indtast nyt id", true);
				String iid = input.next();
				logic.updateUser(id, 2, iid);
				break;
			case 3:
				print("Indtast nyt brugernavn", true);
				String userName = input.next();
				logic.updateUser(id, 3, userName);
				break;
			case 4:
				print("Indtast ny adgangskode", true);
				String pass = input.next();
				logic.updateUser(id, 4, pass);
				break;
			case 5:
				print("Indtast nye initialer", true);
				String ini = input.next();
				logic.updateUser(id, 5, ini);
				break;
			case 6:
				print("Indtast role du ønsker at tilføje", true);
				String addRole = input.next();
				logic.updateUser(id, 6, addRole);
				break;
			case 7:
				print("Indtast role du ønsker at slette", true);
				String removeRole = input.next();
				logic.updateUser(id, 7, removeRole);
				break;
			default:
				print(languageHandler.invalidCommandMessage, true);
				break;
			}

		}

		/*
		 * Først find ud af hvad der skal opdateres... switch måske?
		 * 
		 * Dertil brug setters til at sætte den nye værdi.
		 */

	}

	@Override
	public void deleteUser() throws DALException {
		int userId = -1;
		do {
			print(languageHandler.enterUserIdMessage, false);
			userId = input.nextInt();
			input.nextLine();
		} while (userId == -1 || userId < 11 || userId > 99 && logic.userExist(userId));

		/* Skal vi validere om en bruger med user id'en findes her? */

		String confirm = "";
		do {
			print(languageHandler.userDeletionMessage(userId), false);
			confirm = input.next();
		} while (!confirm.equalsIgnoreCase("y") && !confirm.equalsIgnoreCase("n"));

		if (confirm.equalsIgnoreCase("y")) {
			logic.deleteUser(userId);
			print("Bruger [" + userId + "] er slettet. ", true);
		}

	}

	private void showUsers() throws DALException {
		print(logic.showUsers(), true);
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