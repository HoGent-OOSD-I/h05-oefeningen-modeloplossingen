package cui;

import java.util.Scanner;

import domein.DomeinController;

public class HogerLagerApp {
	private Scanner invoer = new Scanner(System.in);
	private DomeinController dc;
	private final int HOGER = 0;

	public HogerLagerApp(DomeinController domeinController) {
		dc = domeinController;
	}

	public void startHogerLagerSpel() {
		int nieuweWaarde;
		boolean hoger;

		System.out.println("Welkom bij Hoger Lager");
		dc.startHogerLager();

		nieuweWaarde = dc.geefHuidigeKaart();

		do {
			System.out.printf("De waarde van de huidige kaart is %d%n", nieuweWaarde);

			hoger = (invoerKeuze() == HOGER);

			dc.raadHogerLager(hoger);
			nieuweWaarde = dc.geefHuidigeKaart();
			System.out.printf("De waarde van de nieuwe kaart is %d%n", nieuweWaarde);

			System.out.printf("Je hebt dus %S geraden%n", dc.isCorrectGeraden() ? "juist" : "fout");
			System.out.printf("Je score tot nu toe is %d%n", dc.geefScore());
		} while (!dc.isEindeSpel());

		System.out.printf("Je hebt dit spel %s%n", dc.isGewonnen() ? "gewonnen" : "verloren");
	}

	private int invoerKeuze() {
		int keuze;
		do {
			System.out.print("Zal de volgende kaart hoger (0) of lager (1) zijn? ");
			keuze = invoer.nextInt();
		} while (keuze < 0 || keuze > 1);
		return keuze;
	}

}
