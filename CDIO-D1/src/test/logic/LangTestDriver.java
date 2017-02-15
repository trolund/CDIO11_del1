package test.logic;

import ui.LanguageHandler;

public class LangTestDriver {

	public static void main(String[] args) {

		LanguageHandler l = LanguageHandler.getInstance();
		
		System.out.println(l.menuMessage);
		
	}

}
