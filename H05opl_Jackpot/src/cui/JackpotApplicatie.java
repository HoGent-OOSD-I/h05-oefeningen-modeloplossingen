package cui;

import java.util.List;
import java.util.Scanner;
import domein.DomeinController;

public class JackpotApplicatie {

	private Scanner invoer;
	private DomeinController dc;

	public JackpotApplicatie(DomeinController dc)
	{
		this.dc = dc; // NOOIT dc = new DomeinController();
		this.invoer = new Scanner(System.in);
	}

	public void startJackpotspel()
	{
		dc.startNieuweJackpot();

		uitvoerGetallen(dc.geefGetallenWielen());

		int verderSpelen = invoerKeuze();

		while (verderSpelen != 0) {

			dc.speel();

			uitvoerGetallen(dc.geefGetallenWielen());

			System.out.printf("De score is %d%n", dc.geefScore());

			verderSpelen = invoerKeuze();
		}

	}

	private void uitvoerGetallen(List<Integer> getallen)
	{
		for(int getal: getallen)
			System.out.printf("%d ", getal);
		System.out.println();		
	}
	
	private int invoerKeuze()
	{
		int keuze;
		do {
			System.out.printf("Wil je met de jackpot spelen (ja=1, nee=0)? ");
			keuze = invoer.nextInt();
		} while (keuze < 0 || keuze > 1);
		return keuze;
	}
		
}
