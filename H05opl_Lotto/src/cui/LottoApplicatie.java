package cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class LottoApplicatie {
	private static Scanner invoer = new Scanner(System.in);

	public static void main(String[] args) {
		DomeinController dc = new DomeinController();
		int keuze;
		do {
			do {
				System.out.println("MENU");
				System.out.println("1. Registreer een trekking");
				System.out.println("2. Controleer je nummers");
				System.out.println("3. Stoppen");
				System.out.println("Maak je keuze > ");
				keuze = invoer.nextInt();
			} while (keuze < 1 || keuze > 3);

			switch (keuze) {
			case 1 -> doeRegistreerTrekking(dc);
			case 2 -> doeControleerNummers(dc);
			default -> System.out.println("Tot volgende keer!");
			}
		} while (keuze != 3);
		invoer.close();
	}

	private static void doeRegistreerTrekking(DomeinController dc) {
		List<Integer> nummers = new ArrayList<>();
		String naam;

		System.out.println("Registreer een nieuwe trekking.");
		System.out.print("Geef de naam van de trekking > ");
		naam = invoer.next();

		for (int teller = 1; teller <= 6; teller++) {
			System.out.printf("Geef %d%s nummer in > ", teller, teller == 1 ? "ste" : "de");
			nummers.add(invoer.nextInt());
		}

		dc.registreerTrekking(naam, nummers);

		System.out.println("De trekking werd geregistreerd!");
	}

	private static void doeControleerNummers(DomeinController dc) {
		String naam;
		List<Integer> nummers = new ArrayList<>();

		System.out.print("Geef de naam van de trekking waarvoor je je nummers wil controleren > ");
		naam = invoer.next();
		dc.selecteerTrekking(naam);
		do {
			nummers = new ArrayList<Integer>();
			System.out.printf("Geef jouw nummers in.%n");
			for (int teller = 1; teller <= 6; teller++) {
				System.out.printf("Geef %d%s nummer in > ", teller, teller == 1 ? "ste" : "de");
				nummers.add(invoer.nextInt());
			}
			System.out.printf("Met deze nummers win je %d Euro.%n", dc.geefWinst(nummers));
			System.out.println("Wil je nog nummers controleren voor deze trekking? (1=ja, 2=nee)");
		} while (invoer.nextInt() == 1);
	}
}
