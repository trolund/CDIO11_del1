package ui;

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

		String role;
		do {
			print(languageHandler.enterRoleMessage, false);
			role = input.nextLine();
		} while (role == null);

		UserDTO userdto = new UserDTO(cpr, userId, userName, password, ini, role);

		print(languageHandler.userCreatedMessage(userId), true);
		return userdto;
	}
//
//	@Override
//	public void updateUser() throws DALException {
//
//		
//		  print(languageHandler.enterUserIdMessage, true); int userId =
//		  input.nextInt();
//		  
//		  if (!logic.userExists(userId)) {
//		  print(languageHandler.userNotFoundMessage(userId), true); } else {
//		  print(languageHandler.updateMessage, true); int action =
//		  input.nextInt();
//		  
//		  switch (action) { case 1: print(languageHandler.enterNewCprMessage,
//		  true); String newCpr = input.next(); logic. logic.updateUser(userId,
//		  1, newCpr); break; case 2:
//		  print(languageHandler.enterNewUserIdMessage, true); String newUserId
//		  = input.next(); logic.updateUser(userId, 2, newUserId); break; case
//		  3: print(languageHandler.enterNewUserNameMessage, true); String
//		  newUserName = input.next(); logic.updateUser(userId, 3, newUserName);
//		  break; case 4: print(languageHandler.enterNewPasswordMessage, true);
//		  String newPassword = input.next(); logic.updateUser(userId, 4,
//		  newPassword); break; case 5:
//		 * print(languageHandler.enterNewIniMessage, true); String newIni =
//		 * input.next(); logic.updateUser(userId, 5, newIni); break; case 6:
//		 * print(languageHandler.enterAddRoleMessage, true); String addRole =
//		 * input.next(); break; case 7:
//		 * print(languageHandler.enterRemoveRoleMessage, true); String
//		 * removeRole = input.next(); break; default:
//		 * print(languageHandler.invalidCommandMessage, true); break; }
//		 * 
//		 * }
//		 * 
//		 */
//
//	}

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