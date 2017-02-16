package data;

import java.util.List;

public interface IData {

	/* P{DB}Data specific methods */
	public void saveUsers() throws DALException;
	public void loadUsers() throws DALException;

	UserDTO getUser(int userId) throws DALException;
	List<UserDTO> getUserList() throws DALException;
	void createUser(UserDTO user) throws DALException;
	void updateUser(UserDTO user) throws DALException;
	void deleteUser(int userId) throws DALException;

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