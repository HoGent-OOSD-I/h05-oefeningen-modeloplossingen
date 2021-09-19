package domein;

public class Kaart
{
	private int waarde;
	private final String kleur;

	public int getWaarde()
	{
		return this.waarde;
	}

	public Kaart(int waarde, String kleur)
	{
		this.waarde = waarde;
		this.kleur = kleur;
	}

	public int geefBlackjackWaarde()
	{ 
		int temp = waarde <= 10 ? waarde : 10; 
		return temp == 1 ? 11 : temp;
	}
}
