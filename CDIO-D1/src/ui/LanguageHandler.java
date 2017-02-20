package ui;

public class LanguageHandler {

	private static final LanguageHandler instance = new LanguageHandler();

	public final String menuMessage = "\n/--------------------\\\n" + 
									  "| Administrations    |\n" + 
									  "| modul              |\n" +
									  "|--------------------|\n" + 
									  "| Kommando        ID |\n" + 
									  "|--------------------|\n" + 
									  "| Opret bruger     1 |\n" + 
									  "| Vis brugere      2 |\n" + 
									  "| Opdatér bruger   3 |\n" + 
									  "| Slet bruger      4 |\n" +
									  "| Skift datalag    5 |\n" + 
									  "| Afslut           0 |\n" + 
									  "\\--------------------/\n";
	

	public final String updateMessage = "\n/--------------------\\\n" + 
										"| Updatér bruger     |\n" + 
										"|--------------------|\n" + 
										"| Kommando        ID |\n" + 
										"|--------------------|\n" + 
										"| CPR              1 |\n" +
										"| Bruger id        2 |\n" + 
										"| Brugernavn       3 |\n" + 
										"| Adgangskode      4 |\n" + 
										"| initialer        5 |\n" +
										"| Tilføj rolle     6 |\n" + 
										"| Slet rolle       7 |\n" +
										"| Tilbage          0 |\n" +
										"\\-------------------/\n";
	
	public final String switchDALMessage = "\n/--------------------\\\n" + 
											"| Skift datalag      |\n" + 
											"|--------------------|\n" + 
											"| Kommando        ID |\n" + 
											"|--------------------|\n" + 
											"| Ikke persistent  1 |\n" +
											"| Persistent (fil) 2 |\n" + 
											"| Persistent (db)  3 |\n" + 
											"| Tilbage          0 |\n" +
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
	
	public final String enterNewCprMessage = "Indtast nyt CPR" + messageUserSuffix;
	public final String enterNewUserIdMessage = "Indtast nyt bruger id" + messageUserSuffix;
	public final String enterNewUserNameMessage = "Indtast nyt brugernavn" + messageUserSuffix;;
	public final String enterNewPasswordMessage = "Indtast nyt password" + messageUserSuffix;;
	public final String enterNewIniMessage = "Indtast nye initialer" + messageUserSuffix;;
	public final String enterAddRoleMessage = "Tilføj rolle" + messageUserSuffix;
	public final String enterRemoveRoleMessage = "Slet rolle" + messageUserSuffix;
	
	public final String userDeletionMessage(int userId) {
		return messageServerPrefix + "Slet bruger med id [" + userId + "] (y/n)" + messageUserSuffix;
	}
	
	public final String userCreatedMessage (int userId) {
		return messageServerPrefix + "Bruger med id [" + userId + "] er nu oprettet.";
	}
	
	public final String userNotFoundMessage(int userId) {
		return messageServerPrefix + "Bruger med id [" + userId + "] kunne ikke findes.";
	}

	private LanguageHandler() {

	}

	public static synchronized LanguageHandler getInstance() {
		return instance;
	}

}