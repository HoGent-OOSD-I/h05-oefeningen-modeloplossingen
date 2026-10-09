package cui;

import java.util.List;
import java.util.Scanner;
import domein.DomeinController;

public class JackpotApplicatie {

	private DomeinController dc;

	public JackpotApplicatie(DomeinController dc)
	{
		this.dc = dc;  // NOOIT dc = new DomeinController();
	}

	public void startJackpotspel() {
		dc.startNieuweJackpot();

		uitvoerGetallen(dc.geefGetallenWielen());

		int verderSpelen = invoerKeuze();

		while (verderSpelen != 0) {

			dc.speel();

			uitvoerGetallen(dc.geefGetallenWielen());

			IO.println(String.format("De score is %d", dc.geefScore()));

			verderSpelen = invoerKeuze();
		}

	}

	private void uitvoerGetallen(List<Integer> getallen)
	{
		for(int getal: getallen)
			IO.print(String.format("%d ", getal));
		IO.println();		
	}
	
	private int invoerKeuze()
	{
		int keuze;
		do {
			keuze = Integer.parseInt(IO.readln("Wil je met de jackpot spelen (ja=1, nee=0)? "));
		} while (keuze < 0 || keuze > 1);
		return keuze;
	}
		
}
