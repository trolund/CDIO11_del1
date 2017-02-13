package dal;

import java.util.ArrayList;
import java.util.List;

public class Data implements IData {

	private final List<UserDTO> userStore;

	public Data() {
		userStore = new ArrayList<>();

		userStore.add(new UserDTO(0, "Admin", "ADM", "Admin"));
		userStore.add(new UserDTO(1, "PHMC01", "PHMC", "Pharmacist"));
		userStore.add(new UserDTO(2, "FM01", "FM", "Foreman"));
		userStore.add(new UserDTO(3, "OP01", "OP", "Operator"));
	}

	@Override
	public UserDTO getUser(int userId) throws DALException {
		for (int i = 0; i < userStore.size(); i++) {
			if (userStore.get(i).getUserId() == userId) return userStore.get(i);
		}
		/* What to return if the user is not found? */
		return null;
	}

	@Override
	public List<UserDTO> getUserList() throws DALException {
		return userStore;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {
		
	}

	@Override
	public void updateUser(UserDTO user) throws DALException {
		
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		for (int i = 0; i < userStore.size(); i++) {
			if (userStore.get(i).getUserId() == userId) userStore.remove(i);
		}

	}

}