package domein;

public class Categorie
{
	private String omschrijving;
	private int snelheid;
	private int kracht;
	private int lenigheid;

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
		if (!omschrijving.isEmpty() && omschrijving.length() <= 100)
			this.omschrijving = omschrijving;
	}

	public int getSnelheid()
	{
		return snelheid;
	}

	private void setSnelheid(int snelheid)
	{
		if (snelheid > 0)
			this.snelheid = snelheid;
	}

	public int getKracht()
	{
		return kracht;
	}

	private void setKracht(int kracht)
	{
		if (kracht >= 1 && kracht <= 10)
			this.kracht = kracht;
	}

	public int getLenigheid()
	{
		return lenigheid;
	}

	private void setLenigheid(int lenigheid)
	{
		if (lenigheid >= 1 && lenigheid <= 5)
			this.lenigheid = lenigheid;
	}
}
