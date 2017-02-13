package ui;

import logic.IFunc;

public class TUI implements ITUI {

	private IFunc func;

	public TUI(IFunc func) {
		this.func = func;
	}

	@Override
	public void showMessage(String message) {

	}

}