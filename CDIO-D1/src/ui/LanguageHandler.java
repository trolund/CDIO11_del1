package ui;

public class LanguageHandler {

	private static final LanguageHandler instance = new LanguageHandler();

	public final String menuMessage = "\n/--------------------\\\n" + 
									  "| Administrations    |\n" + 
									  "| modul              |\n" +
									  "|--------------------|\n" + 
									  "| Kommando        ID |\n" + 
									  "|--------------------|\n" + 
									  "| Vis hjælp        1 |\n" +
									  "| Opret bruger     2 |\n" + 
									  "| Vis brugere      3 |\n" + 
									  "| Opdatér bruger   4 |\n" + 
									  "| Slet bruger      5 |\n" +
									  "| Skift datalag    6 |\n" + 
									  "| Afslut           0 |\n" + 
									  "\\--------------------/\n";
	
	public final String updateMessage = 
			"\n/--------------------\\\n" + 
	          "| what to change?    |\n" + 
			  "|--------------------|\n" + 
			  "| Kommando        ID |\n" + 
			  "|--------------------|\n" + 
			  "| cpr		      1 |\n" +
			  "| userid           2 |\n" + 
			  "| username         3 |\n" + 
			  "| password         4 |\n" + 
			  "| initials         5 |\n" +
			  "| remove role      6 |\n" + 
			  "| add role         0 |\n" + 
			  "\\-------------------/\n";

	private final String messageUserSuffix = ": ";
	private final String messageServerPrefix = "<< ";
	
	public final String commandMessage = "Kommando" + messageUserSuffix;
	public final String invalidCommandMessage = messageServerPrefix + "Ugyldig kommando.";
	public final String quitMessage = messageServerPrefix + "Lukker administrationsmodul...";

	public final String enterCprMessage = "Indtast CPR" + messageUserSuffix;
	public final String enterUserIdMessage = "Indtast bruger id" + messageUserSuffix;
	public final String enterUserNameMessage = "Indtast brugernavn" + messageUserSuffix;;
	public final String enterPasswordMessage = "Indtast password" + messageUserSuffix;;
	public final String enterIniMessage = "Indtast initialer" + messageUserSuffix;;
	public final String enterRoleMessage = "Indtast rolle" + messageUserSuffix;
	
	public final String userDeletionMessage(int userId) {
		return "Slet bruger med id [" + userId + "] (y/n)" + messageUserSuffix;
	}

	private LanguageHandler() {

	}

	public static synchronized LanguageHandler getInstance() {
		return instance;
	}

}