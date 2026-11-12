package domein;

import java.util.ArrayList;
import java.util.List;

public class Jackpot {

	private List<Wiel> wielen;
    private static final int AANTAL_WIELEN = 3;
    
	public Jackpot() {
		wielen = new ArrayList<>();		

		for(int teller = 1; teller<= AANTAL_WIELEN; teller++)
			wielen.add(new Wiel());
	}

	public List<Integer> geefGetallen() {
		List<Integer> getallenWielen = new ArrayList<>();
		
		for ( Wiel wiel  : wielen  ) {
			getallenWielen.add(wiel.getGetal());
		}
		
		return getallenWielen;
	}

	public void speel() {		
		for ( Wiel wiel  : wielen  ) {
			wiel.draai();
		}
	}
	
	public int geefScore() {
		int aantal = 0;
		
		List<Integer> wielwaarden = geefGetallen();
		wielwaarden.sort(null);     // sorteer de getallen van klein naar groot
		
		// we tellen eerst hoeveel gelijke getallen er zijn
		int vorig = -1;
		for (int waarde: wielwaarden) {
			if (vorig == waarde) // twee opeenvolgende getallen worden telkens vergeleken
				aantal++;
			vorig = waarde;
		}
		// vb: bij drie gelijke getallen, zal aantal 2 zijn
		// want het 1e is gelijk aan het 2e, en het 2e is gelijk aan het 3e getal
		
		if (aantal == wielen.size()-1) { // alle getallen zijn gelijk
			if (wielwaarden.get(0) == 9)
				return 50;
			return 10; // getallen zijn gelijk maar niet 9
		}

		// else is hier nergens nodig dankzij de returnstatements
			
		if (aantal > 0) // twee gelijke getallen
			return 5;
		
		return 0;

		
		/*
		Slechte code: indien aantal wielen wijzigt, dan dien je onderstaande code aan te passen:
		
		int getal1 = wielen.get(0).getGetal();
		int getal2 = wielen.get(1).getGetal();
		int getal3 = wielen.get(2).getGetal();
		
		if (getal1==getal2 && getal2 == getal3) {
			if (getal1==9)
				return 50;
			else
				return 10;
		}else {
			if (getal1==getal2 || getal1==getal3 || getal2==getal3)
				return 5;
			else
				return 0;
		}*/
	}
}
