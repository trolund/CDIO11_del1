package logic;

public interface IFunc {
		
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