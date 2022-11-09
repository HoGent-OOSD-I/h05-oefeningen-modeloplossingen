package domein;

public class Spel
{
	private Dobbelsteen[] dobbelstenen;
	private int score;
	private int eersteWorp; // defaultwaarde 0

	public Spel() 
	{
		score = -1; // dit is geen geldige score die als eindresultaat kan gegeven worden 
		dobbelstenen = new Dobbelsteen[2];
		for (int i = 0; i < dobbelstenen.length; i++)
			dobbelstenen[i] = new Dobbelsteen();
	}

	public void rolDobbelstenen() 
	{ 
		for (Dobbelsteen d : dobbelstenen) 
			d.rol();

		int aantalOgenHuidigeWorp = this.geefAantalOgenWorp(); 

		// volgorde belangrijk: eerst score bepalen, dan eerste worp instellen!
		bepaalScore(aantalOgenHuidigeWorp);
		bepaalEersteWorp(aantalOgenHuidigeWorp);
	}

	private boolean isEersteWorp()
	{
		return (eersteWorp == 0);
	}
	
	private void bepaalScore(int aantalOgenWorp) 
	{ 
		if (isEersteWorp() && (aantalOgenWorp == 7 || aantalOgenWorp == 11))
			score = 2;
		else if (aantalOgenWorp == 7 || aantalOgenWorp == 11)
			score = 0;
		else if (aantalOgenWorp == eersteWorp)
			score = 1;
	}
	
	private void bepaalEersteWorp(int aantalOgenWorp)
	{ 
		// als ik nog niet eerder geworpen had, staat eersteWorp nog op 0 en pas ik dit aan
		if (isEersteWorp()) 
			eersteWorp = aantalOgenWorp; // eersteWorp wordt aangepast!
	}

	public int geefAantalOgenWorp()
	{  
		int aantalOgenHuidigeWorp = 0;
		for (Dobbelsteen d : dobbelstenen) {
			aantalOgenHuidigeWorp += d.getAantalOgen();
		}
		return aantalOgenHuidigeWorp;		
	}

	public int getScore() 
	{ 
		return score;
	}

	public boolean isEindeSpel()
	{
		return score != -1; // het spel eindigt als er een "echte" score bepaald is
	}
}
