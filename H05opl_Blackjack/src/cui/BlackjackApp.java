package cui;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class BlackjackApp
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		//Dit is een test
		DomeinController dc = new DomeinController();
		
		System.out.println("We spelen vandaag Blackjack!");
		
		double inzet;
		do
		{
			System.out.print("Hoeveel bedraagt je inzet in euro? (>0)");
			inzet = s.nextDouble();
		}
		while (inzet <= 0);
		
		dc.startBlackjack(new BigDecimal(inzet));
		
		int antwoord, punten;
		do
		{
			// toon speelbord
			List<String> kaarten = dc.geefSpeelbord();
			for (String kaart : kaarten)
				System.out.println(kaart);
			// en punten
			punten = dc.geefPunten();
			System.out.printf("Je hebt tot nu toe %d punten%n", punten);
			
			do
			{
				System.out.print("Wil je nog een kaart? Typ 0 voor nee en 1 voor ja: ");
				antwoord = s.nextInt();
			}
			while (antwoord < 0 || antwoord > 1);
			
			if (antwoord == 1)
				dc.neemKaart();
		}
		while (antwoord == 1 && !dc.isEindeBlackjack());
		
		System.out.printf("Je hebt %.2f euro gewonnen!", dc.geefWinst().doubleValue());
	}
}
