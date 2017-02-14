package main;

import dal.Data;
import logic.Func;
import ui.TUI;

public class Main {

	public static void main(String[] args) {
		TUI tui = new TUI(new Func(new Data()));
		tui.dialog();
	}

}