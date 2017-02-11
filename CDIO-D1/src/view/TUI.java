package view;

import java.util.Scanner;

public class TUI implements ITUI {

	private final Scanner scanner;

	public TUI() {
		scanner = new Scanner(System.in);
	}

	public void createUser() {

		/**
		 * Skal denne kodeblok evt ind i funktionalitets laget? 
		 * Det er jo noget funktionalitet, på den måde, at man 
		 * får en integer fra brugeren.
		 * 
		 * Vi kunne evt. lave en getUserInt() metode i funktionalitetslaget,
		 * som så returnerer en int ind til TUI laget?
		 */
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