package ui;

import data.IData.DALException;

public interface ITUI {
	void initTUI();
	void print(String message, boolean newLine);
	void createUser() throws DALException;
}