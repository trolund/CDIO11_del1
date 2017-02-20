package main;

import data.NPData;
import data.PData;
import logic.Logic;
import ui.TUI;

public class Main {

	public static void main(String[] args) {
		new TUI(new Logic(new PData())).initTUI();
	}

}