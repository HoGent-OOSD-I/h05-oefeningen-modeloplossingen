package domein;

import java.math.BigDecimal;
import java.util.*;

public class Blackjack {
	private List<Kaart> speelbord;
	private List<Kaart> trekstapel;
	private BigDecimal inzet;

	private static final int BLACKJACK_WAARDE = 21;

	public Blackjack(BigDecimal inzet) {

		this.inzet = inzet;

		trekstapel = maakKaarten();

		// Kaarten schudden
		Collections.shuffle(trekstapel);

		// eerste 2 kaarten toevoegen aan speelbord en verwijderen uit trekstapel
		speelbord = new ArrayList<>();
		for (int i = 1; i <= 2; i++)
			neemKaart();
	}

	private List<Kaart> maakKaarten() {
		String[] kleuren = {"Harten", "Klaveren", "Ruiten", "Schoppen"};
		String[] waarden = {"Aas", "Twee", "Drie", "Vier", "Vijf", "Zes", "Zeven", "Acht", "Negen", "Tien", "Boer", "Dame", "Koning"};
		List<Kaart> trekstapel = new ArrayList<>();
		for (String kleur : kleuren)
			for (String waarde : waarden)
				trekstapel.add(new Kaart(waarde, kleur));
		return trekstapel;
	}

	public List<Kaart> getSpeelbord() {
		return speelbord;
	}

	public int geefPunten() {
		int punten = 0;
		boolean aasAanwezig = false;

		for (Kaart k : speelbord) {
			if (k.geefBlackjackWaarde() == Kaart.AAS_WAARDE)
				aasAanwezig = true;
			punten += k.geefBlackjackWaarde();
		}

		if (aasAanwezig && punten > BLACKJACK_WAARDE)
			punten -= 10;

		return punten;
	}

	public void neemKaart() {
		if (!trekstapel.isEmpty())
			speelbord.add(trekstapel.remove(0));
	}

	public boolean isEindeBlackjack() {
		return geefPunten() >= BLACKJACK_WAARDE;
	}

	public BigDecimal geefWinst() {
		int punten = geefPunten();

		if (punten == BLACKJACK_WAARDE) {
			if (speelbord.size() == 2)
				return inzet.multiply(new BigDecimal(3));
			else
				return inzet.multiply(new BigDecimal(2));
		}
		if (punten < BLACKJACK_WAARDE)
			return inzet;

		return BigDecimal.ZERO;
	}
}
