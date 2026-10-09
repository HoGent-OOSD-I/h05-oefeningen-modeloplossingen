package cui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domein.DomeinController;
import dto.TrekkingDTO;

public class LottoApplicatie {
	
	private DomeinController dc;
	
	public LottoApplicatie(DomeinController dc) {
		this.dc = dc;
	}	
	
	public void startLotto() {
        String[] menuOpties = {"Stoppen", "Registreer een trekking", "Controleer je nummers"};

        int keuze = invoerKeuzeUitOpties("MENU", menuOpties);
		while (keuze != 0) {
			switch (keuze) {
				case 1 -> doeRegistreerTrekking();
				case 2 -> doeControleerNummers();
			}

            keuze = invoerKeuzeUitOpties("MENU",menuOpties);
		}
		IO.println("Tot volgende keer!");
	}

    private int invoerKeuzeUitOpties(String hoofding, String[] opties) {
		int keuze;
		do {
            IO.println(hoofding);
            for(int i = 0; i<opties.length; i++){
                IO.println(String.format("%d: %s", i, opties[i]));
            }

			keuze = invoerGetal("Maak je keuze > ");
		} while (keuze < 0 || keuze > opties.length);
	    return keuze;
    }
    
    private String invoerTekst(String instructie) {
		return IO.readln(instructie);
	}

    private int invoerGetal(String instructie) {
        return Integer.parseInt(IO.readln(instructie));
    }
	
	private LocalDate invoerDatum() {
		int dag = invoerGetal("Geef de dag van de trekking in (1-31): ");
		int maand = invoerGetal("Geef de maand van de trekking in (1-12): ");
		int jaar = invoerGetal("Geef het jaar van de trekking in: ");
        return LocalDate.of(jaar, maand, dag);
	}
    
	private List<Integer> invoerNummers() {
		List<Integer> nummers = new ArrayList<>();
		for (int teller = 1; teller <= dc.geefAantalNummers(); teller++) {
            int nieuwNummer = invoerGetal(String.format("Geef %d%s nummer in > ", teller, teller == 1 ? "ste" : "de"));
			nummers.add(nieuwNummer);
		}
		return nummers;		
	}
	
	private void doeRegistreerTrekking() {
		String naam = invoerTekst("Registreer een nieuwe trekking.\nGeef de naam van de trekking > ");
		LocalDate datum = invoerDatum();
		List<Integer> nummers = invoerNummers();		

		dc.registreerTrekking(naam, datum, nummers);

		IO.println("De trekking werd geregistreerd!");
	}

	private void doeControleerNummers() {
		String naam;
		List<Integer> nummers;
        int keuze;

        List<TrekkingDTO> trekkingDTOS = dc.geefAlleTrekkingen();
        IO.println(String.format("Details trekkingen: \n%-10s %-10s", "Datum", "Naam"));
        for(TrekkingDTO trekkingDTO: trekkingDTOS){
            IO.println(String.format("%10s:%-10s", trekkingDTO.datum(), trekkingDTO.naam()));
        }

        naam = invoerTekst("Geef de naam van de trekking waarvoor je je nummers wil controleren > ");
	    dc.selecteerTrekking(naam);
		
    	TrekkingDTO trekking = dc.geefDetailsGeseleteerdeTrekking();
		
        IO.println(String.format("Trekking gevonden met naam '%s' en datum '%s'",
                trekking.naam(), trekking.datum()));

        do {
            IO.println(String.format("Geef jouw nummers in."));

            nummers = invoerNummers();

            int winst = dc.geefWinst(nummers);
            IO.println(String.format("Met deze nummers win je %d Euro.", winst));

            keuze = invoerKeuzeUitOpties("Wil je nog nummers invoeren?", new String[]{"neen", "ja"});
        } while (keuze == 1);
		
	}
}