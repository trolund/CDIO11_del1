package view;

import java.util.Scanner;

public class TUI implements ITUI {
	
	Scanner input = new Scanner(System.in);
	
	public void createUser(){ // begyndt på opret bruger... 
		System.out.println("Ny bruger:");
		System.out.println("hvad skal bruger id være på brugeren? (vælg mellem 11-99)");
		
		boolean tjek = false;
		int id;
		
		while(!tjek){
			id = input.nextInt();
			if(id < 11 || id > 99) {
			tjek = false; 
			System.err.println("Din id er ikke mellem 11 og 99. prøv igen.");
			
			}
			else tjek = true;
		}
		
		
		
		
		
		
		
	}

}