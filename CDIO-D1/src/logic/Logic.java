package logic;

import data.IData;
import data.UserDTO;
import data.IData.DALException;

public class Logic implements ILogic {

	private IData data;

	public Logic(IData data) {
		this.data = data;
	}

	@Override
	public void createUser(String cpr, int userId, String userName, String password, String ini, String role) {

	}


}