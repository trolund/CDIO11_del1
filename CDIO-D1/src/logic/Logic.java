package logic;

import data.IData;
import data.IData.DALException;
import data.NPData;
import data.PDBData;
import data.PData;
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
	public void updateUser(UserDTO user) throws DALException {
		data.updateUser(user);
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		data.deleteUser(userId);
	}

	public String showUsers() throws DALException {
		StringBuilder sb = new StringBuilder();
		sb.append("\n/----------------------------- Brugere [" + data.getUserList().size()
				+ "] -----------------------------\\\n");
		for (int i = 0; i < data.getUserList().size(); i++)
			sb.append("| " + (i + 1) + ": " + data.getUserList().get(i) + "\n");
		sb.append("\\-----------------------------------------------------------------------/\n");
		return sb.toString();
	}

	public boolean verifyPassword(String password) {
		if (password.length() >= 6 && catCount(password) >= 3) {
			return true;
		} else {
			return false;
		}
	}

	private int catCount(String password) {
		int count = 0;

		for (int i = password.length() - 1; i >= 0; i--) { // tjek for store
															// bogstav kategori
			if (Character.isUpperCase(password.charAt(i))) {
				count++;
				break;
			}
		}

		for (int i = password.length() - 1; i >= 0; i--) { // tjek for små
															// bogstav kategori
			if (Character.isLowerCase(password.charAt(i))) {
				count++;
				break;
			}
		}

		for (int i = password.length() - 1; i >= 0; i--) { // tjek for
															// specialtegn
															// kategori
			int as = password.charAt(i);
			if (as >= 32 && as <= 64 || as >= 91 && as <= 96 || as >= 123 && as <= 126) {
				count++;
				break;
			}
		}

		for (int i = password.length() - 1; i >= 0; i--) { // tjek for tal
															// kategori
			int as = password.charAt(i);
			if (as >= 48 && as <= 57) {
				count++;
				break;
			}
		}

		return count;
	}

	@Override
	public void switchDAL(int command) throws DALException {
		switch (command) {
		case 1:
			data = new NPData();
			break;
		case 2:
			data = new PData();
			break;
		case 3:
			data = new PDBData();
			break;
		default:
			throw new DALException("ERROR!!!!!");
		}
	}

}