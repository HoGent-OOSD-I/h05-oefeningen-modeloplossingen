package cui;

import java.util.Scanner;

import domein.DomeinController;

public class GalgjeApplicatie {

	public static void main(String[] args) {
		DomeinController dc = new DomeinController();
		Scanner invoer = new Scanner(System.in);

		System.out.println("Welkom bij Galgje.");
		System.out.println("==================");
		dc.startGalgje();
		int aantalMissers = dc.geefAantalMissers();
		System.out.printf("Je hebt %d misser%s%n", aantalMissers, aantalMissers == 1 ? "" : "s");
		// toonGalg(aantalMissers);
		System.out.printf("We zoeken: %s%n", dc.geefGemaskeerdWoord());

		while (!dc.isEindeGalgjeBereikt()) {
			System.out.printf("%nGeef een letter in > ");
			dc.kiesLetter(invoer.next().charAt(0));
			aantalMissers = dc.geefAantalMissers();
			System.out.printf("Je hebt %d misser%s%n", aantalMissers, aantalMissers == 1 ? "" : "s");
			// toonGalg(aantalMissers);
			System.out.printf("We zoeken: %s%n", dc.geefGemaskeerdWoord());
		}

		if (dc.isWoordGeraden()) {
			System.out.printf("%nProficiat! Je raadde het woord %s%nJe score is %d!", dc.geefGezochteWoord(),
					dc.geefScore());
		} else
			System.out.printf("%nSorry, je hangt...%nWe zochten %s%nVolgende keer meer success!",
					dc.geefGezochteWoord());
		invoer.close();
	}

	private static void toonGalg(int aantalMissers) {
		switch (aantalMissers) {
		case 1 -> System.out.printf("%n|%n|%n|%n|%n|__%n%n");
		case 2 -> System.out.printf("____%n|%n|%n|%n|%n|__%n%n");
		case 3 -> System.out.printf("____%n|/%n|%n|%n|%n|__%n%n");
		case 4 -> System.out.printf("____%n|/ |%n|%n|%n|%n|__%n%n");
		case 5 -> System.out.printf("____%n|/ |%n|  O%n|%n|%n|__%n%n");
		case 6 -> System.out.printf("____%n|/ |%n|  O%n|  |%n|%n|__%n%n");
		case 7 -> System.out.printf("____%n|/ |%n|  O%n| /|%n|%n|__%n%n");
		case 8 -> System.out.printf("____%n|/ |%n|  O%n| /|\\%n|%n|__%n%n");
		case 9 -> System.out.printf("____%n|/ |%n|  O%n| /|\\%n| /%n|__%n%n");
		case 10 -> System.out.printf("____%n|/ |%n|  O%n| /|\\%n| / \\%n|__%n%n");
		default -> System.out.printf("%n|%n|%n|%n|%n|%n%n");
		}

	}
}
