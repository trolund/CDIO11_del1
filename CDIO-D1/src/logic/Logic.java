package logic;

import java.util.Scanner;

import data.IData;

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
		
		int userId = 0;
		do {
			while (scanner.hasNextLine()) scanner.next();
			userId = scanner.nextInt();
		} while (userId < 11 && userId > 99);

	
	}

}