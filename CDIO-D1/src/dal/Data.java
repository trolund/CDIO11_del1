package dal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data implements IData {

	private final List<UserDTO> userStore;

	public Data() {
		userStore = new ArrayList<>();

		userStore.add(new UserDTO(2, "FM01", "FM", "Foreman"));
		userStore.add(new UserDTO(0, "Admin", "ADM", "Admin"));
		userStore.add(new UserDTO(3, "OP01", "OP", "Operator"));
		userStore.add(new UserDTO(1, "PHMC01", "PHMC", "Pharmacist"));
		
		// Hmm? Skal vi bruge mergesort i stedet? :S
		Collections.sort(userStore);
		
	}

	private UserDTO binarysearch(List<UserDTO> list, int low, int high, int userId) throws DALException {
		if (low > high) throw new DALException("Unable to search in the list. High (" + high + "), low (" + low + ")");

		int mid = low + (high - low) / 2;

		if (list.get(mid).getUserId() == userId) {
			return list.get(mid);
		} else if (list.get(mid).getUserId() > userId) {
			return binarysearch(list, low, mid - 1, userId);
		} else if (list.get(mid).getUserId() < userId) {
			return binarysearch(list, mid + 1, high, userId);
		}

		throw new DALException("User with userId (" + userId + ") not found in the list");
	}

	@Override
	public UserDTO getUser(int userId) throws DALException {
		return binarysearch(userStore, 0, userStore.size() - 1, userId);
	}

	@Override
	public List<UserDTO> getUserList() throws DALException {
		return userStore;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {
		userStore.add(user);
	}

	@Override
	public void updateUser(UserDTO user) throws DALException {

	}

	@Override
	public void deleteUser(int userId) throws DALException {
		for (int i = 0; i < userStore.size(); i++)
			if (userStore.get(i).getUserId() == userId) userStore.remove(i);
	}

}