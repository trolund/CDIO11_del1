package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PData implements IData {
	
	File file = new File("Data.txt");

	@Override
	public UserDTO getUser(int userId) throws DALException {
		
		UserDTO user = null;
		
		try{
		FileInputStream f = new FileInputStream(file);
		ObjectInputStream o = new ObjectInputStream(f);

		
		user = (UserDTO) o.readObject(); // ved ikke hvordan man finde den spesifike user... :(
		
		o.close();
		f.close();
		
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List<UserDTO> getUserList() throws DALException {
		return null;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {
		
		try {
			FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(user);

			o.close();
			f.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} 

	}

	@Override
	public void updateUser(UserDTO user) throws DALException {

	}

	@Override
	public void deleteUser(int userId) throws DALException {

	}

}