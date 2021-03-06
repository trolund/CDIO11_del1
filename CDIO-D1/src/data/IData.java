package data;

import java.util.List;

/**
 * Interface for the Data access layer.
 */
public interface IData {
	UserDTO getUser(int userId) throws DALException;
	List<UserDTO> getUserList() throws DALException;
	void createUser(UserDTO user) throws DALException;
	void updateUser(UserDTO user) throws DALException;
	void deleteUser(int userId) throws DALException;

	/**
	 * Custom DataAccessLayer Exception, used to throw errors from the data
	 * layer.
	 */
	public class DALException extends Exception {
		private static final long serialVersionUID = 1L;

		public DALException(String msg, Throwable e) {
			super(msg, e);
		}

		public DALException(String msg) {
			super(msg);
		}
	}

}