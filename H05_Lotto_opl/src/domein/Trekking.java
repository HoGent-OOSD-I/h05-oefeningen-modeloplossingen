package domein;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Trekking {

	private String naam;
	private List<Integer> nummers;
	public static final int AANTAL_NUMMERS = 6;
	
	public Trekking(String naam, List<Integer> nummers) {
		setNaam(naam);
		setNummers(nummers);
	}

	public String getNaam() {
		return naam;
	}
	
	private void setNaam(String naam)
	{
		if (naam != null && !naam.isBlank())
			this.naam = naam;
	}

	private void setNummers(List<Integer> nummers)
	{
		// GEEN CONTROLE UNIEKE NUMMERS, nog niet alles geleerd om dit op te lossen
		this.nummers = new ArrayList<>(nummers);
	}
	
	public int geefWinst(List<Integer> nummers) {
		// GEEN CONTROLE UNIEKE NUMMERS, nog niet alles geleerd om dit op te lossen
		int aantalJuist = 0;
		for (int nummer : nummers) {
			if (this.nummers.contains(nummer)) {
				aantalJuist++;
			}
		}
		return switch (aantalJuist) {
		case 3, 4 -> 5;
		case 5 -> 10;
		case 6 -> 50;
		default -> 0;
		};
	}
}
