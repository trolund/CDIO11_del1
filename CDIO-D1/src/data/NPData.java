package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * NPData, Non-persistent data layer.
 */
public class NPData implements IData {

	/**
	 * List used to store all of the DTO objects.
	 */
	private final List<UserDTO> userStoreList;

	public NPData() {
		/*
		 * Initializing userStoreList as ArrayList, since we need dynamic
		 * add/remove functionality.
		 */
		userStoreList = new ArrayList<>();

		/*
		 * Adding some dummy DTO objects to the ArrayList. Since this is a
		 * non-persistent DAL, these will not be saved.
		 */
		userStoreList.add(new UserDTO("0123", 12, "FM01", "pass0123", "FM", "Foreman"));
		userStoreList.add(new UserDTO("0122", 15, "Admin", "pass0122", "ADM", "Admin"));
		userStoreList.add(new UserDTO("0121", 13, "OP01", "pass0121", "OP", "Operator"));
		userStoreList.add(new UserDTO("0120", 14, "PHMC01", "pass0121", "PHMC", "Pharmacist"));

		/* Sorted to make sure binary search will function. */
		Collections.sort(userStoreList);
	}

	/**
	 * Binary search implementation specific for UserDTO objects. If the user
	 * with userId is not found, DALException is thrown.
	 */
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

	/**
	 * Use binary search to search for UserDTO object with specific userId.
	 */
	@Override
	public UserDTO getUser(int userId) throws DALException {
		return binarysearch(userStoreList, 0, userStoreList.size() - 1, userId);
	}

	/**
	 * Getter method for the ArrayList, userStoreList.
	 */
	@Override
	public List<UserDTO> getUserList() throws DALException {
		return userStoreList;
	}

	/**
	 * Adds the DTO parameter, user into the ArrayList. Sorted afterwards to
	 * make sure binary search will function.
	 */
	@Override
	public void createUser(UserDTO user) throws DALException {
		userStoreList.add(user);
		Collections.sort(userStoreList);
	}

	/**
	 * Method to update, then overwrite a specified user.
	 */
	@Override
	public void updateUser(UserDTO user) throws DALException {
		userStoreList.remove(binarysearch(userStoreList, 0, userStoreList.size() - 1, user.getUserId()));
		userStoreList.add(user);
		Collections.sort(userStoreList);
	}

	/**
	 * Binary search for the userId, if found the user is removed from the
	 * userStoreList.
	 */
	@Override
	public void deleteUser(int userId) throws DALException {
		userStoreList.remove(binarysearch(userStoreList, 0, userStoreList.size() - 1, userId));
	}

}