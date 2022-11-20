package domein;

public class Kaart
{
	private final int waarde;
	private final int kleur;
	
    private static final String[] BETEKENIS = {"aas", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "tien", "boer", "dame", "koning"};
	private static final int GRENS_WAARDE = 10;
    public static final int AAS_WAARDE = 11;
	
    public Kaart(int waarde, int kleur)
	{
		this.waarde = waarde;
		this.kleur = kleur;
	}

	public int geefBlackjackWaarde()
	{ 
		int temp = waarde <= GRENS_WAARDE ? waarde : GRENS_WAARDE; 
		return temp == 1 ? AAS_WAARDE : temp;
	}
	
	public String geefBetekenisWaarde()
	{
		return BETEKENIS[waarde-1];
	}
}
