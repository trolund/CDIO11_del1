package ui;

import data.IData.DALException;

public interface ITUI {
	void initTUI();
	void createUser() throws DALException;
	void updateUser() throws DALException;
	void deleteUser() throws DALException;
	void print(String message, boolean newLine);
}