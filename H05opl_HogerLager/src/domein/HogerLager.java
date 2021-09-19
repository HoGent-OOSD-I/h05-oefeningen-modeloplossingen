package domein;

import java.util.*;

public class HogerLager
{
	private Kaart huidigeKaart;
	private List<Kaart> trekstapel;
	private int score;

	public int getScore()
	{
		return this.score;
	}

	public HogerLager()
	{
		// 52 kaarten maken
		String[] kleuren = {"klaveren", "harten", "schoppen", "ruiten"};
				
		trekstapel = new ArrayList<>();
		for (String kleur: kleuren)
			for (int waarde=0; waarde<13; waarde++)
				trekstapel.add(new Kaart(waarde+1, kleur));
				
		// Kaarten schudden
		Collections.shuffle(trekstapel);
		
		// 1e kaart van de trekstapel wordt de huidigeKaart
		huidigeKaart = trekstapel.remove(0);
	}

	public int geefWaardeHuidigeKaart()
	{
		return huidigeKaart.getWaarde();
	}

	public boolean raadHogerLager(boolean hogerLager) // hoger = true, lager = false
	{
		int waardeHuidig = geefWaardeHuidigeKaart();
		
		// nieuwe huidige kaart trekken
		huidigeKaart = trekstapel.remove(0);
		int waardeVolgend = geefWaardeHuidigeKaart();
		
		boolean geraden = (waardeHuidig < waardeVolgend && hogerLager) || (waardeHuidig > waardeVolgend && !hogerLager);  
		
		if (geraden) score++;
		
		return geraden;
	}

	public boolean isEindeSpel()
	{
		return trekstapel.isEmpty() || isGewonnen();
	}

	public boolean isGewonnen()
	{
		return score == 15;
	}
}
