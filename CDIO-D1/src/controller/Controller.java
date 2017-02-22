package controller;

import data.IData.DALException;
import logic.ILogic;
import ui.ITUI;
import ui.LanguageHandler;

public class Controller {

	/**
	 * Text user interface and logic layer objects, controlled by this
	 * controller class.
	 */
	private ITUI tui;
	private ILogic logic;

	/**
	 * LanguageHandler object to provide the class with various Strings.
	 */
	private final LanguageHandler languageHandler;

	public Controller(ITUI tui, ILogic logic) {
		this.tui = tui;
		this.logic = logic;
		this.languageHandler = LanguageHandler.getInstance();
	}

	/**
	 * Infinite loop that starts the system. Will ask the user for a command,
	 * and keep waiting until the user has entered one.
	 */
	public void start() {
		while (true) {
			tui.print(languageHandler.menuMessage, true);
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
				} catch (DALException e) {
					tui.printErr(languageHandler.unableToShowUsersErrMessage, true);
				}
				break;
			case 3:
				try {
					logic.updateUser(tui.createUser());
				} catch (DALException e) {
					tui.printErr(languageHandler.userNotUpdatedErrMessage, true);
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
				int commandDAL = tui.getCommand();
				try {
					logic.switchDAL(commandDAL);
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