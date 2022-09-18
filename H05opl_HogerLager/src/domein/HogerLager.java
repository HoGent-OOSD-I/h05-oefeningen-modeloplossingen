package domein;

import java.util.*;

public class HogerLager {

	private Kaart huidigeKaart;
	private List<Kaart> trekstapel;
	private int score;
	private boolean correctGeraden;

    public static final boolean HOGER = true;
    public static final boolean LAGER = !HOGER;	
	
	public HogerLager() {
		
		maakKaarten();
		Collections.shuffle(trekstapel);
		huidigeKaart = deelKaartUit();
	}
	
	private void maakKaarten() {
		String[] kleuren = { "klaveren", "harten", "schoppen", "ruiten" };

		trekstapel = new ArrayList<>();
		for (String kleur : kleuren)
			for (int waarde = 1; waarde <= 13; waarde++)
				trekstapel.add(new Kaart(waarde, kleur));
	}
	
	private Kaart deelKaartUit() {
		if (trekstapel.isEmpty())
			return null;
		return trekstapel.remove(0);
	}
	
	public int getScore() {
		return this.score;
	}

	public int geefWaardeHuidigeKaart() {
		
		return huidigeKaart.getWaarde();
	}

	public void raadHogerLager(boolean hogerLager)
	{
		
		int waardeVorig = geefWaardeHuidigeKaart();
		
		huidigeKaart = deelKaartUit();
		
        if (huidigeKaart == null)
        {
        	correctGeraden = false;
        	return;
        }

		int waardeHuidig = geefWaardeHuidigeKaart();

		correctGeraden = 		
        (hogerLager == HOGER && waardeHuidig > waardeVorig) || 
		(hogerLager == LAGER && waardeHuidig < waardeVorig);
				
		if (correctGeraden)
			score++;
	}

	public boolean isCorrectGeraden() {
		return correctGeraden;
	}

	public boolean isEindeSpel() {
		return trekstapel.isEmpty() || isGewonnen();
	}

	public boolean isGewonnen() {
		return score == 15;
	}
}
