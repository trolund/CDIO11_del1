package view;

import java.util.Scanner;

public class TUI implements ITUI {

	private final Scanner scanner;

	public TUI() {
		scanner = new Scanner(System.in);
	}

	public void createUser() {
		int userId = -1;

		do {
			System.out.print("Bruger Id [11-99]: ");
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.print("Bruger Id [11-99]: ");
			}
			userId = scanner.nextInt();
		} while (userId < 11 || userId > 99);

	}

}