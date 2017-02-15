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
	
	
	public boolean verifyPassword(String pass){
		if(pass.length() >= 6 && katCount(pass) >= 3){
			return true;
		}
		else{
			return false;
		}
	}

	private int katCount(String pass) { // mangler tal tjek
		int count = 0;
		
		
		for(int i = pass.length()-1 ; i >= 0; i--) { // tjek for store bogstav kategori
	        if(Character.isUpperCase(pass.charAt(i))) {
	            count++;
	            break;
	        }
	    }
		
		for(int i = pass.length()-1 ; i >= 0; i--) { // tjek for små bogstav kategori
	        if(Character.isLowerCase(pass.charAt(i))){
	            count++;
	            break;
	        }
	    }
		
		for(int i = pass.length()-1 ; i >= 0; i--) { // tjek for specialtegn kategori
			int as = pass.charAt(i);
	        if(as >= 32 && as <= 64 || as >= 91 && as <= 96 || as >= 123 && as <= 126){
	            count++;
	            break;
	        }
	    }
		
		for(int i = pass.length()-1 ; i >= 0; i--) { // tjek for tal kategori
			int as = pass.charAt(i);
	        if(as >= 48 && as <= 57){
	            count++;
	            break;
	        }
	    }
		
	     
	     
		return count;
	}

}