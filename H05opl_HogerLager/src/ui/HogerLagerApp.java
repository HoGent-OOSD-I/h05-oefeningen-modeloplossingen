package ui;

import java.util.Scanner;

import domein.DomeinController;

public class HogerLagerApp
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		DomeinController dc = new DomeinController();
		int keuze, nieuweWaarde;
		boolean hoger;
		
		System.out.println("Welkom bij Hoger Lager");
		dc.startHogerLager();
		nieuweWaarde = dc.geefHuidigeKaart();
		
		do
		{
			System.out.printf("De waarde van de huidige kaart is %d%n", nieuweWaarde);
			
			do
			{
				System.out.print("Zal de volgende kaart hoger (0) of lager (1) zijn? ");
				keuze = s.nextInt();
			}
			while (keuze < 0 || keuze > 1);
			
			hoger = keuze == 0;
			
			dc.raadHogerLager(hoger);
			nieuweWaarde = dc.geefHuidigeKaart();
			System.out.printf("De waarde van de nieuwe kaart is %d%n", nieuweWaarde);
			
			System.out.printf("Je hebt dus %S geraden%n", dc.isCorrectGeraden() ? "juist" : "fout");
			System.out.printf("Je score tot nu toe is %d%n", dc.geefScore());
		}
		while (!dc.isEindeSpel());
		
		System.out.printf("Je hebt dit spel %s%n", dc.isGewonnen() ? "gewonnen" : "verloren");
	}

}
