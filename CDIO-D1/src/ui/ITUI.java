package ui;

import data.IData.DALException;
import data.UserDTO;

/**
 * TUI interface used to implement the TUI object.
 */
public interface ITUI {
	UserDTO createUser() throws DALException;
	int deleteUser() throws DALException;
	int getCommand();
	void print(String message, boolean newLine);
	void printErr(String message, boolean newLine);
}