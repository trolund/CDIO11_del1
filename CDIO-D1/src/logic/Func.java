package logic;

import dal.IData;
import dal.UserDTO;

public class Func implements IFunc {

	private IData data;

	public Func(IData data) {
		this.data = data;
	}
	
	public void createUser(int userId,String userName, String ini, String cpr, String pass, String role) throws IllegalArgumentException {
		if(userId < 11 || userId > 99){
			
		}
		
		
		
		data.createUser(new UserDTO(userId,userName, ini, cpr));
	}

}