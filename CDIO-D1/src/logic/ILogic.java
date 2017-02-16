package logic;

import data.IData.DALException;

public interface ILogic {
	
	void createUser(int userId, String cpr, String userName, String password, String ini, String role) throws DALException;
	void updateUser(int userId) throws DALException;
	void deleteUser(int userId) throws DALException;
	
	boolean verifyPassword(String password);
	String showUsers() throws DALException;
	
	public class IllegalInputException extends IllegalArgumentException {
		private static final long serialVersionUID = 1L;

		public IllegalInputException(String msg, Throwable e) {
			super(msg, e);
		}

		public IllegalInputException(String msg) {
			super(msg);
		}
	}
	
}