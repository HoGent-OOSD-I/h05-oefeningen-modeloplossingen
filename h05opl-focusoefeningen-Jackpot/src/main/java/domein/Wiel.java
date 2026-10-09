package domein;

import java.security.SecureRandom;

public class Wiel {
	private int getal;
	private SecureRandom sr;
	
	public Wiel() {
		sr = new SecureRandom();
	}

	public int getGetal() {
		return this.getal;
	}

	public void draai() {
		getal = sr.nextInt(10);
	}	
	
}