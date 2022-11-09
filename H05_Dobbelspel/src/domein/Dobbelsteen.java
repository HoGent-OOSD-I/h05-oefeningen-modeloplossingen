package domein;

import java.security.SecureRandom;

public class Dobbelsteen
{
	private int aantalOgen;
	private SecureRandom random; // dient om 1 randomgenerator te maken

	public Dobbelsteen()
	{
		aantalOgen = 1; // geldige waarde!
		random = new SecureRandom(); // randomgenerator aanmaken
	}

	public void rol()
	{ 
		// aantalOgen is een random getal uit [1,6]
		aantalOgen = random.nextInt(1,7); 
		// nextInt(a,b) geeft een geheel getal uit [a,b[
	}

	public int getAantalOgen() 
	{ 
		return aantalOgen;
	}
}
