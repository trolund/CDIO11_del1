package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.IData.DALException;
import data.UserDTO;

public class TUI implements ITUI {

	private final Scanner input;
	private final LanguageHandler languageHandler;

	public TUI() {
		input = new Scanner(System.in);
		this.languageHandler = LanguageHandler.getInstance();
	}

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
		boolean x = true;
		do {
			print(languageHandler.enterRoleMessage, false);
			print(languageHandler.commandMessage, false);

			int action = input.nextInt();
			switch (action) {
			case 1:
				if (roles.contains("Admin")) {
					printErr("brugeren er allerede Admin", true);
				} else {
					roles.add("Admin");
				}
				break;
			case 2:
				if (roles.contains("Pharmacist")) {
					printErr("brugeren er allerede Pharmacist", true);
				}

				else {
					roles.add("Pharmacist");
				}
				break;
			case 3:
				if (roles.contains("Foreman")) {
					printErr("brugeren er allerede Foreman", true);
				} else {
					roles.add("Foreman");
				}
				break;
			case 4:
				if (roles.contains("Operator")) {
					printErr("brugeren er allerede Operator", true);
				} else {
					roles.add("Operator");
				}
				break;
			default:
				print("rolle ikke tilføjet, pågrund af ugryldig komando", true);
			}

			print("vil du tilføje en rolle mere? (y/n)", true);
			String confirm = "";
			confirm = input.next();
			if (confirm.equalsIgnoreCase("y")) {
				x = true;
			} else {
				printErr("rolle tildeling afsluttet", true);
				x = false;
			}

		} while (x);

		UserDTO userdto = new UserDTO(cpr, userId, userName, password, ini);
		userdto.addAll(roles);

		print(languageHandler.userCreatedMessage(userId), true);
		return userdto;
	}

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
		} while (!confirm.equalsIgnoreCase("y") && !confirm.equalsIgnoreCase("n"));

		if (confirm.equalsIgnoreCase("y")) {
			return userId;
		}
		return -1;
	}

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

	@Override
	public void print(String message, boolean newLine) {
		if (newLine) {
			System.out.println(message);
		} else {
			System.out.print(message);
		}
	}

	@Override
	public void printErr(String message, boolean newLine) {
		if (newLine) {
			System.err.println(message);
		} else {
			System.err.print(message);
		}
	}

}