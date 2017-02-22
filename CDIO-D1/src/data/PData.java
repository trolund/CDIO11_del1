package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PData, persistent data layer. Data saved in local file.
 */
public class PData implements IData {

	/**
	 * List used to store all of the DTO objects. File object used to save the
	 * userStoreList locally.
	 */
	private List<UserDTO> userStoreList;
	private final File dataFile;

	public PData() {
		/*
		 * Initializing userStoreList as ArrayList, since we need dynamic
		 * add/remove functionality. Initialize the dataFile object.
		 */
		userStoreList = new ArrayList<>();
		dataFile = new File("data.bin");

		/*
		 * Tries to load the users from existing data.bin file, if not found,
		 * exception is thrown.
		 */
		try {
			loadUsers();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tries to save the userStoreList object into the dataFile.
	 */
	private void saveUsers() throws DALException {
		ObjectOutputStream oOS = null;
		try {
			FileOutputStream fOS = new FileOutputStream(dataFile);
			oOS = new ObjectOutputStream(fOS);
			oOS.writeObject(userStoreList);
		} catch (FileNotFoundException e) {
			throw new DALException("Error locating file", e);
		} catch (IOException e) {
			throw new DALException("Error writing to disk", e);
		} finally {
			if (oOS != null) {
				try {
					oOS.close();
				} catch (IOException e) {
					throw new DALException("Unable to close ObjectStream", e);
				}
			}
		}
		System.out.println("DEBUGGING: Saved to file + " + dataFile.getName() + " + successfully.");
	}

	/**
	 * Tries to load the userStoreList object from the dataFile.
	 */
	@SuppressWarnings("unchecked")
	public void loadUsers() throws DALException {
		ObjectInputStream oIS = null;
		try {
			FileInputStream fIS = new FileInputStream(dataFile);
			oIS = new ObjectInputStream(fIS);
			Object inObj = oIS.readObject();
			if (inObj.getClass().equals(ArrayList.class)) {
				userStoreList = ((ArrayList<UserDTO>) inObj);
			} else {
				throw new DALException("Wrong object in file");
			}
		} catch (FileNotFoundException e) {
			/* No problem - just returning empty userStoreList. */
		} catch (IOException e) {
			throw new DALException("Error while reading disk!", e);
		} catch (ClassNotFoundException e) {
			throw new DALException("Error while reading file - Class not found!", e);
		} finally {
			if (oIS != null) {
				try {
					oIS.close();
				} catch (IOException e) {
					throw new DALException("Error closing pObjectStream!", e);
				}
			}
		}
		System.out.println("DEBUGGING: Loaded from file + " + dataFile.getName() + " + successfully.");
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

		throw new DALException("User with userId [" + userId + "] not found in the list");
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
		sortAndSave();
	}

	/**
	 * Method to update, then overwrite a specified user.
	 */
	@Override
	public void updateUser(UserDTO user) throws DALException {
		for (UserDTO userDTO : userStoreList) {
			if (userDTO.getUserId() == user.getUserId()) {
				userStoreList.remove(userDTO);
				userStoreList.add(user);
				sortAndSave();
				break;
			}
		}
	}

	/**
	 * Binary search for the userId, if found the user is removed from the
	 * userStoreList.
	 */
	@Override
	public void deleteUser(int userId) throws DALException {
		userStoreList.remove(binarysearch(userStoreList, 0, userStoreList.size() - 1, userId));
		sortAndSave();
	}

	/**
	 * Helper method to sort, then save the userStoreList to dataFile.
	 */
	private void sortAndSave() throws DALException {
		Collections.sort(userStoreList);
		saveUsers();
	}

}