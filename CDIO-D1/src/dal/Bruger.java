package dal;

public class Bruger {
	
	private int userID;
	private String userName;
	private String ini;
	private String cpr;
	private String password;
	private roller rolle;
	
	private enum roller {
		Admin, Pharmacist, Foreman, Operator
	}
	public Bruger(int userID, String userName, String ini, String cpr, String password, int rolle) {
		this.userID = userID;
		this.userName = userName;
		this.ini = ini;
		this.cpr = cpr;
		this.password = password;
		
		switch (rolle) {
        case 1: this.rolle =  roller.Admin;
                 break;
        case 2: this.rolle = roller.Pharmacist;
                 break;
        case 3:  this.rolle = roller.Foreman;
                 break;
        case 4:  this.rolle = roller.Operator;
                 break;
        default: this.rolle =  roller.Admin;
        		 break;
		}
		
	};


	
	
	

}




      
