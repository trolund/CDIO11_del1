package logic;

public interface ILogic {
	
	void createUser();
	
	public class IllegalInputException extends IllegalArgumentException {
		private static final long serialVersionUID = 1L;

		public IllegalInputException(String msg, Throwable e) {
			super(msg, e);
		}

		public IllegalInputException(String msg) {
			super(msg);
		}
	}
	
	public boolean verifyPassword(String pass);
	

}