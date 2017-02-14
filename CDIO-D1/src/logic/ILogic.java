package logic;

public interface ILogic {
	
	
	
	public boolean createUser(int userId, String userName, String ini, String cpr, String pass, String role);
	
	
		
	public class IllegalInputException extends IllegalArgumentException {
		private static final long serialVersionUID = 1L;

		public IllegalInputException(String msg, Throwable e) {
			super(msg, e);
		}

		public IllegalInputException(String msg) {
			super(msg);
		}
	}

}