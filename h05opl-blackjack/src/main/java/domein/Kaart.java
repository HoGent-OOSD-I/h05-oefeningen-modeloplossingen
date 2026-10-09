package domein;

public class Kaart
{
	private final String waarde;
	private final String kleur;
	
    private static final int GRENS_WAARDE = 10;
    public static final int AAS_WAARDE = 11;
	
    public Kaart(String waarde, String kleur)
	{
		this.waarde = waarde;
		this.kleur = kleur;
	}

	public String getWaarde() {
		return waarde;
	}

	public String getKleur() {
		return kleur;
	}

	public int geefBlackjackWaarde()
	{ 
		return switch(waarde)
		{
		case "Aas" -> AAS_WAARDE;
		case "Twee" -> 2;
		case "Drie" -> 3;
		case "Vier" -> 4;
		case "Vijf" -> 5;
		case "Zes" -> 6;
		case "Zeven" -> 7;
		case "Acht" -> 8;
		case "Negen" -> 9;
		default -> GRENS_WAARDE;
		};
	}

}