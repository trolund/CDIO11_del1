package data;

import java.util.List;

public class PDBData implements IData {

	@Override
	public void saveUsers() throws DALException {
		
	}

	@Override
	public void loadUsers() throws DALException {
		
	}

	@Override
	public UserDTO getUser(int userId) throws DALException {
		return null;
	}

	@Override
	public List<UserDTO> getUserList() throws DALException {
		return null;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {

	}

	public void updateUser(UserDTO user) throws DALException {

	}

	@Override
	public void deleteUser(int userId) throws DALException {

	}

	@Override
	public void updateUser(int userId, int operation, String input) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExist(int userId) throws DALException {
		// TODO Auto-generated method stub
		return false;
	}

}