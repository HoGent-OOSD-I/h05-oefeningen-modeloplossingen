package domein;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Trekking {

	private String naam;
	private LocalDate datum;
	private List<Integer> nummers;
	public static final int AANTAL_NUMMERS = 6;
	
	public Trekking(String naam, LocalDate datum, List<Integer> nummers) {
		this.naam = naam;
		this.datum = datum;
		// GEEN CONTROLE UNIEKE NUMMERS, nog niet alles geleerd om dit op te lossen
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
