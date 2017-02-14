package logic;

public interface ILogic {

	public void createUser(String cpr, int userId, String userName, String password, String ini, String role);
	

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