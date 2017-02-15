package ui;

public class LanguageHandler {
	
	private static final LanguageHandler instance = new LanguageHandler();
	
	public final String menuMessage = "/--------------------\\\n" 
									 + "| Administrations    |\n"
									 + "| modul              |\n"
									 + "|--------------------|\n"
									 + "| Kommando        ID |\n"
									 + "|--------------------|\n"
									 + "| Vis hjælp        1 |\n"
									 + "| Opret bruger     2 |\n"
									 + "| Vis brugere      3 |\n"
									 + "| Opdatér bruger   4 |\n"
									 + "| Slet bruger      5 |\n"
									 + "| Skift datalag    6 |\n"
									 + "| Afslut           0 |\n"
									 + "\\--------------------/\n";
	
	public final String commandMessage = "Kommando: ";
	public final String invalidCommandMessage = "Ugyldig kommando.";
	public final String quitMessage = "Lukker administrationsmodul...";
	
	public final String enterCprMessage = "Indtast CPR: ";
	public final String enterUserIdMessage = "Indtast bruger id: ";
	public final String enterUserNameMessage = "Indtast brugernavn: ";
	public final String enterPasswordMessage = "Indtast password: ";
	public final String enterIniMessage = "Indtast initialer: ";
	public final String enterRoleMessage = "Indtast rolle: ";

	private LanguageHandler() {

	}

	public static synchronized LanguageHandler getInstance() {
		return instance;
	}

}