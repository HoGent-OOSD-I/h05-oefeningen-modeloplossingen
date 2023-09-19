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
		if (omschrijving == null || omschrijving.isBlank() || omschrijving.length() > 100)
			this.omschrijving = "anoniem";
		else
			this.omschrijving = omschrijving;
			
	}

	public int getSnelheid()
	{
		return snelheid;
	}

	private void setSnelheid(int snelheid)
	{
		this.snelheid = (snelheid <= 0)? 1: snelheid;
	}

	public int getKracht()
	{
		return kracht;
	}

	private void setKracht(int kracht)
	{
		this.kracht = (kracht < 1 || kracht > 10)? 1: kracht;
	}

	public int getLenigheid()
	{
		return lenigheid;
	}

	private void setLenigheid(int lenigheid)
	{
		this.lenigheid = (lenigheid < 1 || lenigheid > 5)? 1: lenigheid;
	}
}
