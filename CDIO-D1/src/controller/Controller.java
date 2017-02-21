package controller;

import data.IData.DALException;
import logic.ILogic;
import ui.ITUI;
import ui.LanguageHandler;

public class Controller {

	private ITUI tui;
	private ILogic logic;

	private final LanguageHandler languageHandler;

	public Controller(ITUI tui, ILogic logic) {
		this.tui = tui;
		this.logic = logic;
		this.languageHandler = LanguageHandler.getInstance();
	}

	public void start() {
		tui.print(languageHandler.menuMessage, true);

		while (true) {
			int command = tui.getCommand();

			switch (command) {
			case 0:
				tui.print(languageHandler.quitMessage, true);
				System.exit(0);
				break;
			case 1:
				try {
					logic.createUser(tui.createUser());
				} catch (DALException e) {
					tui.printErr(languageHandler.userNotCreatedErrMessage, true);
				}
				break;
			case 2:
				try {
					tui.print(logic.showUsers(), true);
				} catch (DALException e1) {
					tui.printErr("Kunne ikke vise brugere! langhandler pls", true);
				}
				break;
			case 3:
				try {
					logic.updateUser(tui.createUser());
				} catch (DALException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
			case 4:
				try {
					logic.deleteUser(tui.deleteUser());
				} catch (DALException e) {
					tui.printErr(languageHandler.userNotDeletedErrMessage, true);
				}
				break;
			case 5:
				tui.print(languageHandler.switchDALMessage, true);
				int command0 = tui.getCommand();
				try {
					logic.switchDAL(command0);
				} catch (DALException e) {
					e.printStackTrace();
				}
				break;
			default:
				tui.print(languageHandler.invalidCommandMessage, true);
				break;
			}

		}

	}

}