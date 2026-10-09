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
		boolean hoger, wilVerderSpelen = true;

		System.out.println("Welkom bij Hoger Lager");
		dc.startHogerLager();
		nieuweKaart = dc.geefHuidigeKaart();
        System.out.printf("De huidige kaart is: %d van %s%n", nieuweKaart.waarde(),
                nieuweKaart.kleur());

		do {
			hoger = (invoerKeuze() == HOGER);

			dc.raadHogerLager(hoger);
            System.out.printf("Je hebt %S geraden%n", dc.isCorrectGeraden() ? "juist" : "fout");

            nieuweKaart = dc.geefHuidigeKaart();
			System.out.printf("%nWant de nieuwe kaart is: %d van %s%n", nieuweKaart.waarde(),
					                                             nieuweKaart.kleur());

            if(!dc.isEindeSpel())
                wilVerderSpelen = leesVerderSpelen() != -1;
		} while (wilVerderSpelen && !dc.isEindeSpel());

		System.out.printf("%nJe score is %d%n", dc.geefScore());
		System.out.printf("Je hebt dit spel %s%n", dc.isGewonnen() ? "gewonnen" : "verloren");
	}

    private int leesVerderSpelen() {
        System.out.print("Wil je verder spelen? Geef -1 in om te stoppen en een willekeurig ander getal om verder te spelen. ");
        return invoer.nextInt();
    }

    private int invoerKeuze() {
		int keuze;
        boolean isJuist;

        do {
			System.out.print("Zal de volgende kaart hoger (0) of lager (1) zijn? ");
			keuze = invoer.nextInt();
            isJuist = keuze >= 0 && keuze <= 1;
        } while (!isJuist);
		return keuze;
	}

}
