package domein;

import java.util.ArrayList;
import java.util.List;

public class Jackpot {

	private List<Wiel> wielen;
    private final int AANTAL_WIELEN = 3;
    
	public Jackpot() {
		 
		wielen = new ArrayList<>();		

		for(int teller = 1; teller<= AANTAL_WIELEN; teller++)
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
		
		int aantal = 0;
		
		List<Integer> wielWaarden = geefGetallenWielen();
		wielWaarden.sort(null);
		
		for(int wielNr = 0; wielNr< wielWaarden.size()-1; wielNr++)
		{
			if (wielWaarden.get(wielNr) == wielWaarden.get(wielNr+1))
			{
				aantal++;
			}
		}
		if (aantal == wielen.size()-1) {
			if (wielWaarden.get(0) == 9)
				return 50;
			return 10;
		}
			
		if (aantal > 0)
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
