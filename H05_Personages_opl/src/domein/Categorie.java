package domein;

public class Categorie
{
	private String omschrijving;
	private int snelheid;
	private int kracht;
	private int lenigheid;

	private static final String DEFAULT_OMSCHRIJVING = "anoniem";
	private static final int MIN_SNELHEID = 1;
	private static final int MIN_KRACHT = 1;
	private static final int MAX_KRACHT = 10;
	private static final int MIN_LENINGHEID = 1;
	private static final int MAX_LENINGHEID = 5;
	
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
		this.omschrijving = (omschrijving == null || omschrijving.isBlank() || omschrijving.length() > 100)?
				DEFAULT_OMSCHRIJVING: omschrijving;
			
	}

	public int getSnelheid()
	{
		return snelheid;
	}

	private void setSnelheid(int snelheid)
	{
		this.snelheid = (snelheid < MIN_SNELHEID)? MIN_SNELHEID: snelheid;
	}

	public int getKracht()
	{
		return kracht;
	}

	private void setKracht(int kracht)
	{
		this.kracht = (kracht < MIN_KRACHT || kracht > MAX_KRACHT)? MIN_KRACHT: kracht;
	}

	public int getLenigheid()
	{
		return lenigheid;
	}

	private void setLenigheid(int lenigheid)
	{
		this.lenigheid = (lenigheid < MIN_LENINGHEID || lenigheid > MAX_LENINGHEID)? MIN_LENINGHEID: lenigheid;
	}
}
