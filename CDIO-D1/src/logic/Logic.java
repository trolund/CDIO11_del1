package logic;

import java.util.Scanner;

import data.IData;
import data.IData.DALException;
import data.UserDTO;

public class Logic implements ILogic {

	private IData data;
	private final Scanner input;

	public Logic(IData data) {
		this.data = data;
		input = new Scanner(System.in);
	}
	
	@Override
	public void createUser(String cpr, int userId, String userName, String password, String ini, String role) {

		/* Hvor skal denne exception catches? */
		try {
			data.createUser(new UserDTO(cpr, userId, userName, password, ini, role));
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getStringInput() {
		String message;
		do {
			while (!input.hasNextLine()) input.next();
			message = input.nextLine();
		} while (message != null && message.length() > 1);
		return message;
	}
	
	@Override
	public int getIntInput() {
		int value;
		do {
			while (!input.hasNextInt()) input.next();
			value = input.nextInt();
		} while (value < 0);
		return value;
	}
	
}