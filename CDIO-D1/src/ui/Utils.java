package ui;

public class Utils {
	
	public boolean verifyPassword(String password) {
		if (password.length() >= 6 && catCount(password) >= 3) {
			return true;
		} else {
			return false;
		}
	}

	private int catCount(String password) {
		int count = 0;

		for (int i = password.length() - 1; i >= 0; i--) { // tjek for store bogstav kategori
			if (Character.isUpperCase(password.charAt(i))) {
				count++;
				break;
			}
		}

		for (int i = password.length() - 1; i >= 0; i--) { // tjek for små bogstav kategori
			if (Character.isLowerCase(password.charAt(i))) {
				count++;
				break;
			}
		}

		for (int i = password.length() - 1; i >= 0; i--) { // tjek for specialtegn kategori
			int as = password.charAt(i);
			if (as >= 32 && as <= 64 || as >= 91 && as <= 96 || as >= 123 && as <= 126) {
				count++;
				break;
			}
		}

		for (int i = password.length() - 1; i >= 0; i--) { // tjek for tal kategori
			int as = password.charAt(i);
			if (as >= 48 && as <= 57) {
				count++;
				break;
			}
		}

		return count;
	}


}