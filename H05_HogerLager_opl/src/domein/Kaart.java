package domein;

public class Kaart
{
	private int waarde;
	private String kleur;

	public Kaart(int waarde, String kleur)
	{
		this.waarde = waarde;
		this.kleur = kleur;
	}
	
	public int getWaarde()
	{
		return this.waarde;
	}

}
