package cui;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import dto.KaartDTO;

public class BlackjackApplicatie {
	
	private Scanner invoer = new Scanner(System.in);
	private DomeinController dc;

	public BlackjackApplicatie(DomeinController domeinController) {
		dc = domeinController;
	}

	public void startBlackjack() {
		System.out.println("We spelen vandaag Blackjack!");

		double inzet = invoerInzet();

		dc.startBlackjack(new BigDecimal(inzet));

		int antwoord;
		
		toonSpeelbord();
		toonPunten();
		
		do {
			antwoord = invoerAntwoord();

			if (antwoord == 1) {
				dc.neemKaart();
				toonSpeelbord();
				toonPunten();
			}
		} while (antwoord == 1 && !dc.isEindeBlackjack());

		System.out.printf("Je hebt %.2f euro gewonnen!", dc.geefWinst().doubleValue());
	}

	private double invoerInzet() {
		double inzet;
		do {
			System.out.print("Hoeveel bedraagt je inzet in euro? (>0)");
			inzet = invoer.nextDouble();
		} while (inzet <= 0);
		return inzet;
	}

	private void toonSpeelbord() {
		List<KaartDTO> kaarten = dc.geefSpeelbord();
		for (KaartDTO kaart : kaarten)
			System.out.printf("Deze kaart is een %s %s%n", kaart.kleur(), kaart.waarde());
	}

	private void toonPunten() {
		int punten = dc.geefPunten();
		System.out.printf("Je hebt tot nu toe %d punten%n", punten);
	}

	private int invoerAntwoord() {
		int antwoord;
		do {
			System.out.print("Wil je nog een kaart? Typ 0 voor nee en 1 voor ja: ");
			antwoord = invoer.nextInt();
		} while (antwoord < 0 || antwoord > 1);
		return antwoord;
	}
}
