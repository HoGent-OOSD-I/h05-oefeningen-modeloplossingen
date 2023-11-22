package domein;

public class Personage
{
	private String naam;
	private Categorie categorie;
	
	private static final String DEFAULT_CATEGORIE = "anoniem";
	
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
		this.naam = (naam == null || naam.isBlank() || 
				    naam.length() < 3 || naam.length() > 50)?
				DEFAULT_CATEGORIE: naam;
	}
	
	public Categorie getCategorie()
	{
		return categorie;
	}
}