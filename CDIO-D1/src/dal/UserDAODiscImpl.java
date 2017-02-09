package dal;

import java.util.ArrayList;
import java.util.List;

import dto.UserDTO;

public class UserDAODiscImpl implements IUserDAO {
	
	List<Bruger> brugere = new ArrayList<Bruger>();
	

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

	@Override
	public void updateUser(UserDTO user) throws DALException {

	}

	@Override
	public void deleteUser(int userId) throws DALException {

	}

}