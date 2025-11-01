package cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class LottoApplicatie {
	
	private Scanner invoer = new Scanner(System.in);
    private DomeinController dc;
    private static final int JA = 1;
    private static final int NEE = 2;

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
		while(keuze < JA || keuze > NEE);
		return keuze;
	}
	
	private String geefNaam(String vraag)
	{
		System.out.print(vraag);
		return invoer.next();	
	}
	
	private void doeRegistreerTrekking() {
		//SSD UC1 aflezen
		String naam = geefNaam("Geef de naam van de trekking > ");
		List<Integer> nummers = invoerNummers();
		
		dc.registreerTrekking(naam, nummers);

		System.out.println("De trekking werd geregistreerd!");
	}

	private void doeControleerNummers() {
		//SSD UC2
		List<Integer> nummers;
        int keuze;

		String naam = geefNaam("Geef de naam van de trekking waarvoor je je nummers wil controleren > ");
		dc.selecteerTrekking(naam);
		
		do {
			System.out.println("Geef jouw nummers in.");

			nummers = invoerNummers();
			
			System.out.printf("Met deze nummers win je %d Euro.%n", dc.geefWinst(nummers));
			keuze = invoerNogControleren(); 
		} while (keuze == JA);
	}
}
