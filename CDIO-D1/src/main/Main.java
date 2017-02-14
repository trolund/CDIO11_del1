package main;

import dal.NPData;
import logic.Func;
import ui.TUI;

public class Main {

	public static void main(String[] args) {
		TUI tui = new TUI(new Func(new NPData()));
		tui.dialog();
	}

}