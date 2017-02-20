package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import data.IData.DALException;

public class NPData implements IData {

	private final List<UserDTO> userStoreList;

	public NPData() {
		userStoreList = new ArrayList<>();

		/* Test data */
		userStoreList.add(new UserDTO("0123", 12, "FM01", "pass0123", "FM", "Foreman"));
		userStoreList.add(new UserDTO("0122", 15, "Admin", "pass0122", "ADM", "Admin"));
		userStoreList.add(new UserDTO("0121", 13, "OP01", "pass0121", "OP", "Operator"));
		userStoreList.add(new UserDTO("0120", 14, "PHMC01", "pass0121", "PHMC", "Pharmacist"));
		Collections.sort(userStoreList);
	}

	/**
	 * This method are not used in this 
	 * data layer implementation.
	 */
	@Override
	public void loadUsers() throws DALException {

	}

	/**
	 * This method are not used in this 
	 * data layer implementation.
	 */
	@Override
	public void saveUsers() throws DALException {

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
		Collections.sort(userStoreList);
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		userStoreList.remove(binarysearch(userStoreList, 0, userStoreList.size() - 1, userId));
	}
	
	public boolean userExist(int id) throws DALException{
		
		UserDTO user = binarysearch(userStoreList, 0, userStoreList.size() - 1, id);
		if(user == null){
			return false;
		}
		else{
			return true;
		}
}
	
	
	public void updateUser(int userId, int opraton, String input) throws DALException{
		for (Iterator iterator = userStoreList.iterator(); iterator.hasNext();) {
			UserDTO userDTO = (UserDTO) iterator.next();

			if(userDTO.getUserId() == userId){
				switch(opraton){
				case 1: userDTO.setCpr(input); break;
				case 2: int x = Integer.parseInt(input); userDTO.setUserId(x); break;
				case 3: userDTO.setUserName(input); break;
				case 4: userDTO.setPassword(input); break;
				case 5: userDTO.setIni(input); break;
				case 6: userDTO.addRole(input); break;
				case 7: userDTO.removeRole(input); break;
				}
				
				
				
				
				
			}
			
		}
		
		
	}

}