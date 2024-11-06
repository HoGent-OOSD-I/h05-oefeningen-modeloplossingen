package cui;

import java.util.Scanner;

import domein.DomeinController;
import dto.KaartDTO;

public class HogerLagerApplicatie {
	
	private Scanner invoer = new Scanner(System.in);
	private DomeinController dc;
	private final int HOGER = 0;

	public HogerLagerApplicatie(DomeinController domeinController) {
		dc = domeinController;
	}

	public void startHogerLagerSpel() {
		KaartDTO nieuweKaart;
		boolean hoger;

		System.out.println("Welkom bij Hoger Lager");
		dc.startHogerLager();
		nieuweKaart = dc.geefHuidigeKaart();

		do {
			System.out.printf("De huidige kaart is: %d van %s%n", nieuweKaart.waarde(), 
					                                              nieuweKaart.kleur());

			hoger = (invoerKeuze() == HOGER);

			dc.raadHogerLager(hoger);
			nieuweKaart = dc.geefHuidigeKaart();
			System.out.printf("De nieuwe kaart is: %d van %s%n", nieuweKaart.waarde(), 
					                                             nieuweKaart.kleur());

			System.out.printf("Je hebt dus %S geraden%n", dc.isCorrectGeraden() ? "juist" : "fout");
			System.out.printf("Je score tot nu toe is %d%n%n", dc.geefScore());
		} while (!dc.isEindeSpel());

		System.out.printf("Je score is %d%n%n", dc.geefScore());
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
