package domein;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dto.KaartDTO;

public class DomeinController
{
	private Blackjack blackjack;

	public void maakBlackjack(BigDecimal inzet)
	{
		blackjack = new Blackjack(inzet);
	}

	public List<KaartDTO> geefSpeelbord()
	{
		List<Kaart> kaarten = blackjack.getSpeelbord();
		List<KaartDTO> speelbord = new ArrayList<>();
		
		for (Kaart k : kaarten)
			speelbord.add(new KaartDTO(k.getWaarde(), k.getKleur()));
		
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
