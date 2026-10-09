package domein;

public class Personage
{
	private String naam = DEFAULT_NAAM;
	private Categorie categorie;
	
	private static final String DEFAULT_NAAM = "anoniem";
    private static final int MIN_AANTAL_TEKENS_NAAM = 3;
    private static final int MAX_AANTAL_TEKENS_NAAM = 50;
	
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
        if(naam != null && !naam.isBlank() &&
                naam.length()>= MIN_AANTAL_TEKENS_NAAM && naam.length() <= MAX_AANTAL_TEKENS_NAAM)
		    this.naam = naam;
	}
	
	public Categorie getCategorie()
	{
		return categorie;
	}
}