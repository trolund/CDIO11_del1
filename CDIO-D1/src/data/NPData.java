package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NPData implements IData {

	private final List<UserDTO> userStoreList;

	public NPData() {
		userStoreList = new ArrayList<>();

		userStoreList.add(new UserDTO("0123", 12, "FM01", "pass0123", "FM", "Foreman"));
		userStoreList.add(new UserDTO("0122", 15, "Admin", "pass0122", "ADM", "Admin"));
		userStoreList.add(new UserDTO("0121", 13, "OP01", "pass0121", "OP", "Operator"));
		userStoreList.add(new UserDTO("0120", 14, "PHMC01", "pass0121", "PHMC", "Pharmacist"));
		Collections.sort(userStoreList);
	}

	private UserDTO binarysearch(List<UserDTO> list, int low, int high, int userId) throws DALException {
		if (low > high)
			throw new DALException("Unable to search in the list. High (" + high + "), low (" + low + ")");

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
		return binarysearch(userStoreList, 0, userStoreList.size() - 1, userId);
	}

	@Override
	public List<UserDTO> getUserList() throws DALException {
		return userStoreList;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {
		userStoreList.add(user);
		Collections.sort(userStoreList);
	}

	@Override
	public void updateUser(UserDTO user) throws DALException {
		
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		userStoreList.remove(binarysearch(userStoreList, 0, userStoreList.size() - 1, userId));
	}

}