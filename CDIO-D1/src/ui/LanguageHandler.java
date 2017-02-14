package ui;

public class LanguageHandler {
	
	private static final LanguageHandler instance = new LanguageHandler();
	
	public final String menuMessage = "/--------------------\\\n" 
									 + "| Administrations    |\n"
									 + "| modul              |\n"
									 + "|--------------------|\n"
									 + "| Kommando        ID |\n"
									 + "|--------------------|\n"
									 + "| Vis hjælp        0 |\n"
									 + "| Opret bruger     1 |\n"
									 + "| Vis brugere      2 |\n"
									 + "| Opdatér bruger   3 |\n"
									 + "| Slet bruger      4 |\n"
									 + "\\-------------------/";

	private LanguageHandler() {

	}

	public static synchronized LanguageHandler getInstance() {
		return instance;
	}

}