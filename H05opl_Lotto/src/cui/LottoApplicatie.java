package cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class LottoApplicatie {
	
	private Scanner invoer = new Scanner(System.in);
    private DomeinController dc;

	public LottoApplicatie(DomeinController domeinController) {
		dc = domeinController;
	}
	
	public void startLotto()
	{
		int keuze = invoerKeuze();
		while (keuze != 3)
		{
			switch (keuze) {
				case 1 -> doeRegistreerTrekking();
				case 2 -> doeControleerNummers();
			}
			keuze = invoerKeuze();
		}
		System.out.println("Tot volgende keer!");		
	}

    private int invoerKeuze()
    {
		int keuze;
		do {
			System.out.println("MENU");
			System.out.println("1. Registreer een trekking");
			System.out.println("2. Controleer je nummers");
			System.out.println("3. Stoppen");
			System.out.println("Maak je keuze > ");
			keuze = invoer.nextInt();
		} while (keuze < 1 || keuze > 3);
	    return keuze;
    }
    
	private List<Integer> invoerNummers()
	{
		List<Integer> nummers = new ArrayList<>();
		for (int teller = 1; teller <= dc.aantalNummers(); teller++) {
			System.out.printf("Geef %d%s nummer in > ", teller, teller == 1 ? "ste" : "de");
			nummers.add(invoer.nextInt());
		}
		return nummers;		
	}

	private int invoerNogControleren()
	{
		int keuze;
		do
		{
			System.out.print("Wil je nog nummers controleren voor deze trekking? (1=ja, 2=nee) :");
            keuze = invoer.nextInt();
		}
		while(keuze < 1 || keuze > 2);
		return keuze;
	}
	
	private void doeRegistreerTrekking() {
		List<Integer> nummers;
		String naam;

		System.out.println("Registreer een nieuwe trekking.");
		System.out.print("Geef de naam van de trekking > ");
		naam = invoer.next();

		nummers = invoerNummers();		

		dc.registreerTrekking(naam, nummers);

		System.out.println("De trekking werd geregistreerd!");
	}

	private void doeControleerNummers() {
		String naam;
		List<Integer> nummers;
        int keuze;

		System.out.print("Geef de naam van de trekking waarvoor je je nummers wil controleren > ");
		naam = invoer.next();
		dc.selecteerTrekking(naam);
		
		do {
			System.out.printf("Geef jouw nummers in.%n");

			nummers = invoerNummers();
			
			System.out.printf("Met deze nummers win je %d Euro.%n", dc.geefWinst(nummers));
			keuze = invoerNogControleren(); 
		} while (keuze == 1);
	}
}
