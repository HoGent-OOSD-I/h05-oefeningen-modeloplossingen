package domein;

public class Personage
{
	private String naam;
	private Categorie categorie;
	
	public Personage(String naam, Categorie categorie)
	{
		setNaam(naam);
		this.categorie = categorie;
	}
	
	public String getNaam()
	{
		return naam;
	}
	
	private void setNaam(String naam)
	{
		if (naam == null || naam.isBlank() || naam.length() < 3 || naam.length() > 50)
			this.naam = "anoniem";
		else
			this.naam = naam;
	}
	
	public Categorie getCategorie()
	{
		return categorie;
	}
}