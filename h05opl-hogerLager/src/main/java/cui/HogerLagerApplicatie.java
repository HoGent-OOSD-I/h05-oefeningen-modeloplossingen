package cui;

import domein.DomeinController;
import dto.KaartDTO;

public class HogerLagerApplicatie {
	
	private DomeinController dc;
	private final int HOGER = 0;

	public HogerLagerApplicatie(DomeinController domeinController) {
		dc = domeinController;
	}

	public void startHogerLagerSpel() {
		KaartDTO nieuweKaart;
		boolean hoger, wilVerderSpelen = true;

		IO.println("Welkom bij Hoger Lager");
		dc.startHogerLager();
		nieuweKaart = dc.geefHuidigeKaart();
        IO.println(String.format("De huidige kaart is: %d van %s", nieuweKaart.waarde(),
                nieuweKaart.kleur()));

		do {
			hoger = (invoerKeuze() == HOGER);

			dc.raadHogerLager(hoger);
            IO.println(String.format("Je hebt %S geraden", dc.isCorrectGeraden() ? "juist" : "fout"));

            nieuweKaart = dc.geefHuidigeKaart();
			IO.println(String.format("%nWant de nieuwe kaart is: %d van %s", nieuweKaart.waarde(),
					                                             nieuweKaart.kleur()));

            if(!dc.isEindeSpel())
                wilVerderSpelen = leesVerderSpelen() != -1;
		} while (wilVerderSpelen && !dc.isEindeSpel());

		IO.println(String.format("%nJe score is %d", dc.geefScore()));
		IO.println(String.format("Je hebt dit spel %s", dc.isGewonnen() ? "gewonnen" : "verloren"));
	}

    private int leesVerderSpelen() {
        return Integer.parseInt(IO.readln("Wil je verder spelen? Geef -1 in om te stoppen en een willekeurig ander getal om verder te spelen. "));
    }

    private int invoerKeuze() {
		int keuze;
        boolean isJuist;

        do {
			keuze = Integer.parseInt(IO.readln("Zal de volgende kaart hoger (0) of lager (1) zijn? "));
            isJuist = keuze >= 0 && keuze <= 1;
        } while (!isJuist);
		return keuze;
	}

}
