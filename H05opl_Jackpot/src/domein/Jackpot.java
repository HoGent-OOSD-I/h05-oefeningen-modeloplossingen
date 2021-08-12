package domein;

import java.util.*;

public class Jackpot {

	private List<Wiel> wielen;

	public Jackpot() {
		 
		wielen = new ArrayList<>();
		
		for(int teller = 1; teller<= 3; teller++)
			wielen.add(new Wiel());
	}

	public List<Integer> geefGetallenWielen() {
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
		
		int getal1 = wielen.get(0).getGetal();
		int getal2 = wielen.get(1).getGetal();
		int getal3 = wielen.get(2).getGetal();
		
		if (getal1==getal2 && getal2 == getal3) {
			if (getal1==9)
				return 50;
			else
				return 10;
		}else {
			//TODO
			if (getal1==getal2 || getal1==getal3 || getal2==getal3)
				return 5;
			else
				return 0;
		}
	}
}
