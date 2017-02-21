package ui;

import data.IData.DALException;
import data.UserDTO;

public interface ITUI {
	UserDTO createUser() throws DALException;
	void updateUser() throws DALException;
	int deleteUser() throws DALException;
	int getCommand();
	void print(String message, boolean newLine);
	void printErr(String message, boolean newLine);
}