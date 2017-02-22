package main;

import controller.Controller;
import data.IData;
import data.PData;
import logic.ILogic;
import logic.Logic;
import ui.ITUI;
import ui.TUI;

public class Main {

	/**
	 * Main method that initializes the three different layers and starts the
	 * system with the Controller object.
	 */
	public static void main(String[] args) {
		IData data = new PData("data.bin");
		ILogic logic = new Logic(data);
		ITUI tui = new TUI();
		Controller controller = new Controller(tui, logic);
		controller.start();
	}

}