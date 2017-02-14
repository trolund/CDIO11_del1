package logic;

import java.util.Scanner;

import data.IData;

public class Logic implements ILogic {

	private IData data;
	private final Scanner input;

	public Logic(IData data) {
		this.data = data;
		input = new Scanner(System.in);
	}

	@Override
	public void createUser() {

	}

}