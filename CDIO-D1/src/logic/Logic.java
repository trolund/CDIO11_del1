package logic;

import java.util.Scanner;

import data.IData;
import data.UserDTO;

public class Logic implements ILogic {

	private IData data;

	private final Scanner scanner;

	public Logic(IData data) {
		this.data = data;
		scanner = new Scanner(System.in);
	}

	@Override
	public void createUser() {

		/*
		 * Hvis vi gør det sådan her, er vi sikret en ID inden for intervallet.
		 * 
		 * Der fremkommer bare det problem, at vi ikke kommer til at kunne sysout noget.
		 * 
		 * Ved ikke om det skal gøre det sådan?
		 */

		/* Bruger CPR */
		String cpr = null;
		do {
			System.out.println("DEBUG: CPR: ");
			while (!scanner.hasNextLine()) scanner.next();
			cpr = scanner.next();
		} while (cpr == null);

		/* UserId */
		int userId = 0;
		do {
			System.out.println("DEBUG: Id");
			while (!scanner.hasNextInt()) scanner.next();
			userId = scanner.nextInt();
		} while (userId < 11 && userId > 99);

		/* UserName */
		String userName = null;
		do {
			System.out.println("DEBUG: UserName: ");
			while (!scanner.hasNextLine()) scanner.next();
			userName = scanner.next();
		} while (userName == null);

		
		/* Og så for alle de andre attributter. 
		 * 
		 * Og så laver man brugeren til sidst, som sådan her. 
		 */
		 
		UserDTO newUser = new UserDTO(cpr, userId, userName, null, null, null);
		
		/* 
		 * osv. Tror dog de scanners er lidt fucked.
		 * 
		 */
	}

}