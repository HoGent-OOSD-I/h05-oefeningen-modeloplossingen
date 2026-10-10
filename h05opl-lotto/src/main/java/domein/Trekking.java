package domein;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trekking {

    private String naam;
	private LocalDate datum;
	private List<Integer> nummers;

	public static final int AANTAL_NUMMERS = 6;
    private static final int MIN_NUMMER = 1;
    private static final int MAX_NUMMER = 45;

    public Trekking(String naam, LocalDate datum, List<Integer> nummers) {
		this.naam = naam;
		this.datum = datum;
        setNummers(nummers);
	}

    private void setNummers(List<Integer> nummers) {
        // GEEN CONTROLE UNIEKE NUMMERS, nog niet alles geleerd om dit op te lossen
        for(int nummer: nummers){
            if(nummer < MIN_NUMMER || nummer > MAX_NUMMER )
                throw new IllegalArgumentException("Nummer buiten grenzen ingegeven!");
        }
        this.nummers = new ArrayList<>(nummers);
    }

    public String getNaam() {
		return naam;
	}
	
	public LocalDate getDatum() {
		return datum;
	}

	public int geefWinst(List<Integer> nummers) {
		int aantalJuiste = 0;
		for(int nummer: this.nummers) {
			if(nummers.contains(nummer))
				aantalJuiste++;
		}

		int winst = switch(aantalJuiste) {
            case 3, 4 -> 5;
            case 5 -> 10;
            case 6 -> 50;
            default -> 0;
		};
		return winst;
	}
}
