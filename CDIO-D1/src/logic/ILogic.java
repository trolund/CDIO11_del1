package logic;

import data.IData.DALException;

public interface ILogic {
	
	void createUser(int userId, String cpr, String userName, String password, String ini, String role) throws DALException;
	public boolean verifyPassword(String password);
	public String showUsers() throws DALException;
	
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