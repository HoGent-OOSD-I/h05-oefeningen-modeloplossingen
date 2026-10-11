package domein;

public class Personage {
	private String naam;
	private Categorie categorie;
	
    private static final int MIN_AANTAL_TEKENS_NAAM = 3;
    private static final int MAX_AANTAL_TEKENS_NAAM = 50;
	
	public Personage(String naam, Categorie categorie) {
		setNaam(naam);
        setCategorie(categorie);
    }

    public String getNaam() {
		return naam;
	}
	
	private void setNaam(String naam) {
        if(naam == null || naam.isBlank())
            throw new IllegalArgumentException("Naam moet ingevuld zijn!");
        if(naam.length() < MIN_AANTAL_TEKENS_NAAM || naam.length() > MAX_AANTAL_TEKENS_NAAM)
            throw new IllegalArgumentException("Naam voldoet niet aan de domeinregels!");

        this.naam = naam;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

    private void setCategorie(Categorie categorie) {
        if(categorie == null)
            throw new IllegalArgumentException("Categorie moet ingevuld zijn!");

        this.categorie = categorie;
    }
}