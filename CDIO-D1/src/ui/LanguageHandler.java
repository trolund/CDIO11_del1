package ui;

public class LanguageHandler {
	
	private static final LanguageHandler instance = new LanguageHandler();
	
	private final String menuMessage = "/--------------------\\n" 
									 + "|  Administrations   |\n"
									 + "|  modul             |\n"
									 + "|--------------------|\n"
									 + "| Kommando        ID |\n"
									 + "|--------------------|\n"
									 + "| Opret bruger     1 |"
									 + "| ";

	private LanguageHandler() {

	}

	public static synchronized LanguageHandler getInstance() {
		return instance;
	}

}