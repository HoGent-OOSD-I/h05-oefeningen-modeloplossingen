package cui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import dto.TrekkingDTO;

public class LottoApplicatie {
	
	private Scanner invoer = new Scanner(System.in);
	private DomeinController dc; 
	
	private static final int REGISTREER = 1;
	private static final int CONTROLE_NUMMERS = 2;
	private static final int STOP = 3;
	
	public LottoApplicatie(DomeinController dc) {
		this.dc = dc;
	}	
	
	public void startLotto()
	{
		int keuze = invoerKeuze();
		while (keuze != STOP)
		{
			switch (keuze) {
				case REGISTREER -> doeRegistreerTrekking();
				case CONTROLE_NUMMERS -> doeControleerNummers();
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
		} while (keuze < 1 || keuze > STOP);
	    return keuze;
    }
    
    private String invoerTekst(String instructie) {
		String naam;

		System.out.print(instructie);
		naam = invoer.nextLine();
		return naam;
	}
	
	private LocalDate invoerDatum() {
		System.out.print("Geef de dag van de trekking in (1-31): ");
		int dag = invoer.nextInt(); 
		System.out.print("Geef de maand van de trekking in (1-12): ");
		int maand = invoer.nextInt(); 
		System.out.print("Geef het jaar van de trekking in: ");
		int jaar = invoer.nextInt(); 
		return LocalDate.of(jaar, maand, dag); 
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
		invoer.nextLine(); 	// buffer voor tekst inlezen NA getal
		
		String naam = invoerTekst("Registreer een nieuwe trekking.\nGeef de naam van de trekking > ");
		LocalDate datum = invoerDatum();
		List<Integer> nummers = invoerNummers();		

		dc.registreerTrekking(naam, datum, nummers);

		System.out.println("De trekking werd geregistreerd!");
	}

	private void doeControleerNummers() {
		String naam;
		List<Integer> nummers;
        int keuze;

        List<TrekkingDTO> trekkingDTOS = dc.geefAlleTrekkingen();
        System.out.printf("Details trekkingen: \n%-10s %-10s%n", "Datum", "Naam");
        for(TrekkingDTO trekkingDTO: trekkingDTOS){
            System.out.printf("%10s:%-10s%n", trekkingDTO.datum(), trekkingDTO.naam());
        }
        
		invoer.nextLine(); 	// buffer voor tekst inlezen NA getal

        naam = invoerTekst("Geef de naam van de trekking waarvoor je je nummers wil controleren > ");
	    dc.selecteerTrekking(naam);
		
    	TrekkingDTO trekking = dc.geefTrekking(); 
		
		if(trekking == null) 
			System.out.println("Geen trekking gevonden");
		else
		{
			System.out.printf("Trekking gevonden met naam '%s' en datum '%s%n'",
					trekking.naam(), trekking.datum());
			
			do {
				System.out.printf("Geef jouw nummers in.%n");

				nummers = invoerNummers();
				
				int winst = dc.geefWinst(nummers);
				System.out.printf("Met deze nummers win je %d Euro.%n", winst);
				keuze = invoerNogControleren(); 
			} while (keuze == 1);
		}
		
	}
}