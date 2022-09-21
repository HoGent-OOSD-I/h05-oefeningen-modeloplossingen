package domein;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DomeinController
{
	private Blackjack blackjack;

	public void startBlackjack(BigDecimal inzet)
	{
		blackjack = new Blackjack(inzet);
	}

	public List<String> geefSpeelbord()
	{
		List<Kaart> kaarten = blackjack.getSpeelbord();
		List<String> speelbord = new ArrayList<>();
		
		for (Kaart k : kaarten)
			speelbord.add(k.geefBetekenisWaarde());
		
		return speelbord;
	}

	public int geefPunten()
	{
		return blackjack.geefPunten();
	}

	public void neemKaart()
	{
		blackjack.neemKaart();
	}

	public boolean isEindeBlackjack()
	{
		return blackjack.isEindeBlackjack();
	}
	
	public BigDecimal geefWinst()
	{
		return blackjack.geefWinst();
	}
}
