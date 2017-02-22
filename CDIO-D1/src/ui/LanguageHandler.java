package ui;

/**
 * Singleton class. LanguageHandler class holds all the String information used
 * in the entire system.
 */
public class LanguageHandler {

	private static final LanguageHandler instance = new LanguageHandler();

	public final String menuMessage = "\n/--------------------\\\n" + "| Administrations    |\n"
			+ "| modul              |\n" + "|--------------------|\n" + "| Kommando        ID |\n"
			+ "|--------------------|\n" + "| Opret bruger     1 |\n" + "| Vis brugere      2 |\n"
			+ "| Opdatér bruger   3 |\n" + "| Slet bruger      4 |\n" + "| Skift datalag    5 |\n"
			+ "| Afslut           0 |\n" + "\\--------------------/\n";

	public final String updateMessage = "\n/--------------------\\\n" + "| Updatér bruger     |\n"
			+ "|--------------------|\n" + "| Kommando        ID |\n" + "|--------------------|\n"
			+ "| CPR              1 |\n" + "| Bruger id        2 |\n" + "| Brugernavn       3 |\n"
			+ "| Adgangskode      4 |\n" + "| initialer        5 |\n" + "| Tilføj rolle     6 |\n"
			+ "| Slet rolle       7 |\n" + "| Tilbage          0 |\n" + "\\-------------------/\n";

	public final String switchDALMessage = "\n/--------------------\\\n" + "| Skift datalag      |\n"
			+ "|--------------------|\n" + "| Kommando        ID |\n" + "|--------------------|\n"
			+ "| Ikke persistent  1 |\n" + "| Persistent (fil) 2 |\n" + "| Tilbage          0 |\n"
			+ "\\-------------------/\n";

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
	public final String enterRoleMessage = "\n/--------------------\\\n" + "| Vælg rolle         |\n"
			+ "|--------------------|\n" + "| Rolle           ID |\n" + "|--------------------|\n"
			+ "| Admin            1 |\n" + "| Pharmacist       2 |\n" + "| Foreman          3 |\n"
			+ "| Operator         4 |\n" + "\\-------------------/\n\n";

	public final String anotherRoleMessage = messageServerPrefix + "Flere roller? (y/n)";

	public final String userNotCreatedErrMessage = messageServerPrefix + "Brugeren blev ikke oprettet!";
	public final String userNotUpdatedErrMessage = messageServerPrefix + "Brugeren blev ikke opdateret!";
	public final String userNotDeletedErrMessage = messageServerPrefix + "Brugeren blev ikke slettet!";
	public final String unableToShowUsersErrMessage = messageServerPrefix + "Kunne ikke vise brugere!";

	public final String adminRole = "Admin";
	public final String pharmacistRole = "Pharmacist";
	public final String foremanRole = "Foreman";
	public final String operatorRole = "Operator";

	public final String yInput = "y";
	public final String nInput = "n";

	public final String userDeletionMessage(int userId) {
		return messageServerPrefix + "Slet bruger med id [" + userId + "] (y/n)" + messageUserSuffix;
	}

	public final String userCreatedMessage(int userId) {
		return messageServerPrefix + "Bruger med id [" + userId + "] er nu oprettet.";
	}

	public final String duplicateRoleMessage(String role) {
		return messageServerPrefix + "Brugeren er allerede " + role + ".";
	}

	private LanguageHandler() {

	}

	public static synchronized LanguageHandler getInstance() {
		return instance;
	}

}