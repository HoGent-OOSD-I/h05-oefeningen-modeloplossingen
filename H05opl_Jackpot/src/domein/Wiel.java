package domein;

import java.security.SecureRandom;

public class Wiel {

	private int getal;

	public Wiel() {
		setGetal(0);	//overbodig, want defaultwaarde voor int is 0
	}

	private void setGetal(int getal) {
		this.getal = getal;
	}

	public int getGetal() {
		return this.getal;
	}

	public void draai() {
		SecureRandom sr = new SecureRandom();
		setGetal(sr.nextInt(10));
	}
	
	
}
