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
									 + "| Afslut           0 |\n"
									 + "\\--------------------/";

	private LanguageHandler() {

	}

	public static synchronized LanguageHandler getInstance() {
		return instance;
	}

}