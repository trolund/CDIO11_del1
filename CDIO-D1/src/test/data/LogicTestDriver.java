package test.data;

import data.PData;
import logic.Logic;

public class LogicTestDriver {

	public static void main(String[] args) {
		Logic l = new Logic(new PData());
		
		l.createUser();
		
		
	}

}