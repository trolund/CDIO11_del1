package logic;

import data.IData.DALException;

public interface ILogic {
	void createUser(int userId, String cpr, String userName, String password, String ini, String role) throws DALException;
	void updateUser(int userId, int i, String cpr) throws DALException;
	void deleteUser(int userId) throws DALException;
	
	boolean verifyPassword(String password);
	String showUsers() throws DALException;		
	boolean userExists(int id) throws DALException;
}