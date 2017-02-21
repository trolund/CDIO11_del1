package logic;

import data.UserDTO;
import data.IData.DALException;

public interface ILogic {
	void createUser(UserDTO user) throws DALException;
	void updateUser(UserDTO user) throws DALException;
	void deleteUser(int userId) throws DALException;
	String showUsers() throws DALException;
	boolean verifyPassword(String password);
}