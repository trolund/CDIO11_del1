package ui;

import logic.ILogic;

public class TUI implements ITUI {

	private ILogic logic;

	private final LanguageHandler languageHandler;

	public TUI(ILogic logic) {
		this.logic = logic;
		this.languageHandler = LanguageHandler.getInstance();
	}

	public void initTUI() {
		while (true) {
			print(languageHandler.menuMessage);

			print("Kommando: ");
			int command = logic.getIntInput();

			switch (command) {
			case 1:
				break;
			case 2:
				createUser();
				break;
			case 3:
				break;
			default:
				print("Ugyldig kommando.");
				break;
			}
		}
	}

	@Override
	public void createUser() {
		print("Indtast CPR: ");
		String cpr = logic.getStringInput();

		print("Indtast bruger id:");
		int userId = logic.getIntInput();

		print("Indtast brugernavn:");
		String userName = logic.getStringInput();

		print("Indtast password: ");
		String password = logic.getStringInput();

		print("Indtast initialer:");
		String ini = logic.getStringInput();

		print("Intdtast rolle: ");
		String role = logic.getStringInput();

		logic.createUser(cpr, userId, userName, password, ini, role);
	}

	@Override
	public void print(String message) {
		System.out.println(message);
	}

}