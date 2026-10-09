package domein;

public class Categorie
{
	private String omschrijving = DEFAULT_OMSCHRIJVING;
	private int snelheid = MIN_SNELHEID;
	private int kracht = MIN_KRACHT;
	private int lenigheid = MIN_LENINGHEID;

	private static final String DEFAULT_OMSCHRIJVING = "anoniem";
	private static final int MIN_SNELHEID = 1;
	private static final int MIN_KRACHT = 1;
	private static final int MAX_KRACHT = 10;
	private static final int MIN_LENINGHEID = 1;
	private static final int MAX_LENINGHEID = 5;
    private static final int MIN_LENGTE_OMSCHRIJVING = 100;
	
	public Categorie(String omschrijving, int snelheid, int kracht, int lenigheid)
	{
		setOmschrijving(omschrijving);
		setSnelheid(snelheid);
		setKracht(kracht);
		setLenigheid(lenigheid);
	}

	public String getOmschrijving()
	{
		return omschrijving;
	}

	private void setOmschrijving(String omschrijving)
	{
        if(omschrijving != null && !omschrijving.isBlank() && omschrijving.length() <= MIN_LENGTE_OMSCHRIJVING) // geen spaties controleer je voorlopig alleen in de applicatie.
            this.omschrijving = omschrijving;
	}

	public int getSnelheid()
	{
		return snelheid;
	}

	private void setSnelheid(int snelheid)
	{
        if(snelheid >= MIN_SNELHEID)
		    this.snelheid = snelheid;
	}

	public int getKracht()
	{
		return kracht;
	}

	private void setKracht(int kracht)
	{
        if(kracht >= MIN_KRACHT && kracht <= MAX_KRACHT)
		    this.kracht = kracht;
	}

	public int getLenigheid()
	{
		return lenigheid;
	}

	private void setLenigheid(int lenigheid)
	{
        if(lenigheid >= MIN_LENINGHEID && lenigheid <= MAX_LENINGHEID)
		    this.lenigheid = lenigheid;
	}
}
