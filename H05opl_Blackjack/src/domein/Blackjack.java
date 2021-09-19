package domein;

import java.math.BigDecimal;
import java.util.*;

public class Blackjack
{
	private List<Kaart> speelbord;
	private List<Kaart> trekstapel;
	private BigDecimal inzet;

	public Blackjack(BigDecimal inzet)
	{
		// inzet bijhouden
		this.inzet = inzet;
		
		// 52 kaarten maken
		String[] kleuren = {"klaveren", "harten", "schoppen", "ruiten"};
				
		trekstapel = new ArrayList<>();
		for (String kleur: kleuren)
			for (int waarde=0; waarde<13; waarde++)
				trekstapel.add(new Kaart(waarde+1, kleur));
				
		// Kaarten schudden
		Collections.shuffle(trekstapel);
		
		// eerste 2 kaarten toevoegen aan speelbord en verwijderen uit trekstapel
		speelbord = new ArrayList<>();
		for (int i = 0; i < 2; i++)
			neemKaart();
	}

	public List<Kaart> getSpeelbord()
	{
		return speelbord;
	}

	public int geefPunten()
	{
		int punten = 0;
		boolean aasAanwezig = false;
		
		for (Kaart k : speelbord)
		{
			if (k.geefBlackjackWaarde() == 11) 
				aasAanwezig = true;
			punten += k.geefBlackjackWaarde();
		}
		
		if (aasAanwezig && punten > 21)
			punten -= 10;
		
		return punten;
	}

	public void neemKaart()
	{
		speelbord.add(trekstapel.remove(0));
	}
	
	public boolean isEindeBlackjack()
	{
		return geefPunten() > 21;
	}

	public BigDecimal geefWinst()
	{
		int punten = geefPunten();
		
		if (punten == 21)
		{
			if (speelbord.size() == 2)
				return inzet.multiply(new BigDecimal(3));
			else
				return inzet.multiply(new BigDecimal(2));
		}
		if (punten < 21)
			return inzet;
		
		return BigDecimal.ZERO;
	}
}
