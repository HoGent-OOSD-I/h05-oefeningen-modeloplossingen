package domein;

import java.util.List;

public class DomeinController {

	private Jackpot jackpot;

	public void startNieuweJackpot() {
		this.jackpot = new Jackpot();
	}

	public List<Integer> geefGetallenWielen() {
		return jackpot.geefGetallenWielen();
	}

	public void speel() {
		jackpot.speel();
	}

	public int geefScore() {
		return jackpot.geefScore();
	}
	
}