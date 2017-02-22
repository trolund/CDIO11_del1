package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.IData.DALException;
import data.UserDTO;

public class TUI implements ITUI {

	/**
	 * Scanner object for user input and languageHandler object for various
	 * Strings for output messages.
	 */
	private final Scanner input;
	private final LanguageHandler languageHandler;

	public TUI() {
		input = new Scanner(System.in);
		this.languageHandler = LanguageHandler.getInstance();
	}

	/**
	 * Method to prompt the user for all needed variables to create a new
	 * UserDTO object.
	 */
	@Override
	public UserDTO createUser() throws DALException {
		String cpr;
		do {
			print(languageHandler.enterCprMessage, false);
			cpr = input.next();
		} while (cpr == null || cpr.length() != 10);

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
		} while (userName == null || userName.length() <= 1 || userName.length() >= 21);

		String password;
		do {
			print(languageHandler.enterPasswordMessage, false);
			password = input.nextLine();
		} while (password == null);

		String ini;
		do {
			print(languageHandler.enterIniMessage, false);
			ini = input.nextLine();
		} while (ini == null);

		List<String> roles = new ArrayList<>();
		boolean askForRole = true;

		do {
			print(languageHandler.enterRoleMessage, false);
			int command = getCommand();

			switch (command) {
			case 1:
				if (roles.contains(languageHandler.adminRole)) {
					printErr(languageHandler.duplicateRoleMessage(languageHandler.adminRole), true);
				} else {
					roles.add(languageHandler.adminRole);
				}
				break;
			case 2:
				if (roles.contains(languageHandler.pharmacistRole)) {
					printErr(languageHandler.duplicateRoleMessage(languageHandler.pharmacistRole), true);
				} else {
					roles.add(languageHandler.pharmacistRole);
				}
				break;
			case 3:
				if (roles.contains(languageHandler.foremanRole)) {
					printErr(languageHandler.duplicateRoleMessage(languageHandler.foremanRole), true);
				} else {
					roles.add(languageHandler.foremanRole);
				}
				break;
			case 4:
				if (roles.contains(languageHandler.operatorRole)) {
					printErr(languageHandler.duplicateRoleMessage(languageHandler.operatorRole), true);
				} else {
					roles.add(languageHandler.operatorRole);
				}
				break;
			default:
				print(languageHandler.invalidCommandMessage, true);
			}

			print(languageHandler.anotherRoleMessage, true);

			String confirm = "";
			confirm = input.next();

			if (confirm.equalsIgnoreCase(languageHandler.yInput)) {
				askForRole = true;
			} else {
				askForRole = false;
			}
		} while (askForRole);

		UserDTO userdto = new UserDTO(cpr, userId, userName, password, ini);
		userdto.addAll(roles);

		print(languageHandler.userCreatedMessage(userId), true);
		return userdto;
	}

	/**
	 * Method that deletes an user associated with the specified userId, if it
	 * exists.
	 */
	@Override
	public int deleteUser() throws DALException {
		int userId = -1;

		do {
			print(languageHandler.enterUserIdMessage, false);
			userId = input.nextInt();
			input.nextLine();
		} while (userId == -1 || userId < 11 || userId > 99);

		String confirm = "";
		do {
			print(languageHandler.userDeletionMessage(userId), false);
			confirm = input.next();
		} while (!confirm.equalsIgnoreCase(languageHandler.yInput)
				&& !confirm.equalsIgnoreCase(languageHandler.nInput));

		if (confirm.equalsIgnoreCase(languageHandler.yInput)) {
			return userId;
		}
		return -1;
	}

	/**
	 * Receive a command from the user.
	 */
	@Override
	public int getCommand() {
		int command = -1;
		do {
			print(languageHandler.commandMessage, false);
			while (!input.hasNextInt()) {
				print(languageHandler.commandMessage, false);
				input.next();
			}
			command = input.nextInt();
		} while (command == -1);
		return command;
	}

	/**
	 * Print normally to System.out.
	 */
	@Override
	public void print(String message, boolean newLine) {
		if (newLine) {
			System.out.println(message);
		} else {
			System.out.print(message);
		}
	}

	/**
	 * Print to System.err.
	 */
	@Override
	public void printErr(String message, boolean newLine) {
		if (newLine) {
			System.err.println(message);
		} else {
			System.err.print(message);
		}
	}

}