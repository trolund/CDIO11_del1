package main;

import controller.Controller;
import data.IData;
import data.PData;
import logic.ILogic;
import logic.Logic;
import ui.ITUI;
import ui.TUI;

public class Main {

	public static void main(String[] args) {
		IData data = new PData();
		ILogic logic = new Logic(data);
		ITUI tui = new TUI();
		Controller controller = new Controller(tui, logic);
		controller.start();
	}

}