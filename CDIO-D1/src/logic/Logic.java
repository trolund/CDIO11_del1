package logic;

import data.IData;
import data.IData.DALException;
import data.UserDTO;

public class Logic implements ILogic {

	private IData data;

	public Logic(IData data) {
		this.data = data;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {
		data.createUser(user);
	}

	@Override
	public void updateUser(UserDTO user) throws DALException{
		data.updateUser(user);
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		data.deleteUser(userId);
	}
/*
	public String showUsers() throws DALException {
		StringBuilder sb = new StringBuilder();
		sb.append("\n/----------------------------- Brugere [" + data.getUserList().size() + "] -----------------------------\\\n");
		for (int i = 0; i < data.getUserList().size(); i++)
			sb.append("| " + (i+1) + ": " + data.getUserList().get(i) + "\n");
		sb.append("\\-----------------------------------------------------------------------/\n");
		return sb.toString();
	}
	*/
	

}