package test.logic;

import data.IData;
import data.IData.DALException;
import data.PData;

public class PDataTestDriver {

	public static void main(String[] args) {

		PData data = new PData();

		
		try {
			data.loadUsers();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}