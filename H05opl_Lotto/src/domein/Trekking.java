package domein;

import java.util.ArrayList;
import java.util.List;

public class Trekking {

	private String naam;
	private List<Integer> nummers;

	public Trekking(String naam, List<Integer> nummers) {
		this.naam = naam;
		this.nummers = new ArrayList<Integer>(nummers);
	}

	public String getNaam() {
		return naam;
	}

	public int geefWinst(List<Integer> nummers) {
		int aantalJuist = 0, winst = 0;
		for (int nummer : nummers) {
			if (this.nummers.contains(nummer)) {
				aantalJuist++;
			}
		}
		switch (aantalJuist) {
		case 3, 4 -> winst = 5;
		case 5 -> winst = 10;
		case 6 -> winst = 50;
		}
		return winst;
	}
}
