package domein;

import java.util.List;

public class DomeinController {

	private Jackpot jackpot;

	public void startNieuweJackpot() {
		this.jackpot = new Jackpot();
	}

	public List<Integer> geefGetallen() {
		return jackpot.geefGetallen();
	}

	public void speel() {
		jackpot.speel();
	}

	public int geefScore() {
		return jackpot.geefScore();
	}
	
}