package logic;

import data.IData.DALException;
import data.UserDTO;

/**
 * Interface for the business logic layer.
 */
public interface ILogic {
	void createUser(UserDTO user) throws DALException;
	void updateUser(UserDTO user) throws DALException;
	void deleteUser(int userId) throws DALException;
	String showUsers() throws DALException;
	boolean verifyPassword(String password);
	void switchDAL(int command) throws DALException;
}