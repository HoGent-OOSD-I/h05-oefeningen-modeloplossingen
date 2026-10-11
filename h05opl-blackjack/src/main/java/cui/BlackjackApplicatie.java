package cui;

import java.math.BigDecimal;
import java.util.List;

import domein.DomeinController;
import dto.KaartDTO;

public class BlackjackApplicatie {
	
	private DomeinController dc;
	
	public BlackjackApplicatie(DomeinController domeinController) {
		dc = domeinController;
	}

	public void startBlackjack() {
		IO.println("We spelen vandaag Blackjack!");

		double inzet = invoerInzet();

		dc.maakBlackjack(new BigDecimal(inzet));

		int antwoord;
		
		toonSpeelbord();
		toonPunten();

        antwoord = invoerAntwoord();

        while(antwoord != 0 && !dc.isEindeBlackjack()) {
            dc.neemKaart();
            toonSpeelbord();
            toonPunten();

            if(!dc.isEindeBlackjack())
                antwoord = invoerAntwoord();
        }

        BigDecimal winst = dc.geefWinst();   // TODO vervang null, haal hier de effectieve winst op.
        IO.println(String.format("Je hebt %.2f euro gewonnen!", winst.doubleValue()));
	}

	private double invoerInzet() {
		double inzet;
		do {
			inzet = Double.parseDouble(IO.readln("Hoeveel bedraagt je inzet in euro? (>0): "));
		} while (inzet <= 0);
		return inzet;
	}

	private void toonSpeelbord() {
		List<KaartDTO> kaarten = dc.geefSpeelbord();
		for (KaartDTO kaart : kaarten)
			IO.println(String.format("Deze kaart is een %s %s", kaart.kleur(), kaart.waarde()));
	}

	private void toonPunten() {
		int punten = dc.geefPunten();
		IO.println(String.format("Je hebt tot nu toe %d punten", punten));
	}

	private int invoerAntwoord() {
		int antwoord;
		do {
            antwoord = Integer.parseInt(IO.readln("Wil je nog een kaart? Typ 0 voor nee en 1 voor ja: "));
		} while (antwoord < 0 || antwoord > 1);
		return antwoord;
	}
}
