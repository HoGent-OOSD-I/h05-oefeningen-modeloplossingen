package domein;

import java.security.SecureRandom;

public class Dobbelsteen
{
	private int aantalOgen;
	private SecureRandom sr; // dient om 1 randomgenerator te maken

	public Dobbelsteen()
	{
		aantalOgen = 1; // geldige waarde!
		sr = new SecureRandom(); // randomgenerator aanmaken
	}

	public void rol()
	{ 
		// aantalOgen is een random getal uit [1,6]
		aantalOgen = 1 + sr.nextInt(6); // nextInt(n) geeft een geheel getal uit [0,n[
	}

	public int getAantalOgen() 
	{ 
		return aantalOgen;
	}
}
