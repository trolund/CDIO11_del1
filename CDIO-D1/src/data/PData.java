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
import java.util.Iterator;
import java.util.List;

public class PData implements IData {

	private List<UserDTO> userStoreList;
	private final File dataFile;

	public PData() {
		userStoreList = new ArrayList<>();
		dataFile = new File("data.bin");

		try {
			loadUsers();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

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
			// No problem - just returning empty userStoreList
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
		sortAndSave();
	}

	@Override
	public void updateUser(UserDTO user) throws DALException {
		for (UserDTO userDTO : userStoreList) {
			if(userDTO.getUserId() == user.getUserId()){
				userStoreList.remove(userDTO);
				userStoreList.add(user);
				sortAndSave();
				break;
			}
		}
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		userStoreList.remove(binarysearch(userStoreList, 0, userStoreList.size() - 1, userId));
		sortAndSave();
	}

	private void sortAndSave() throws DALException {
		Collections.sort(userStoreList);
		saveUsers();
	}

}