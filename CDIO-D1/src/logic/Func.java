package logic;

import dal.IData;
import dal.IData.DALException;
import dal.UserDTO;

public class Func implements IFunc {

	private IData data;

	public Func(IData data) {
		this.data = data;
	}

	public boolean createUser(int userId, String userName, String ini, String cpr, String pass, String role) {
		if (userId < 11 || userId > 99) {
			
		} else {
			throw new IllegalInputException("Bruger id skal være mellem 11 og 99!");
		}

		/* What to do with the exception here? */
		try {
			data.createUser(new UserDTO(userId, userName, ini, cpr));
			return true;
		} catch (DALException e) {
			e.printStackTrace();
			
		}
		return false;
		
	}

}