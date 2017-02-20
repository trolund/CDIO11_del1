package logic;

import data.UserDTO;
import data.IData.DALException;

public interface ILogic {
	void createUser(UserDTO user) throws DALException;
	void updateUser(UserDTO user) throws DALException;
	void deleteUser(int userId) throws DALException;
	
	boolean verifyPassword(String password);
	String showUsers() throws DALException;		
	boolean userExists(int id) throws DALException;
}