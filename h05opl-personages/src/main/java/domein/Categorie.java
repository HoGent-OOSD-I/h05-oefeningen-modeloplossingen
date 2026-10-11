package domein;

public class Categorie {
	private String omschrijving;
	private int snelheid;
	private int kracht;
	private int lenigheid;

	private static final int MIN_SNELHEID = 1;
	private static final int MIN_KRACHT = 1;
	private static final int MAX_KRACHT = 10;
	private static final int MIN_LENINGHEID = 1;
	private static final int MAX_LENINGHEID = 5;
    private static final int MAX_LENGTE_OMSCHRIJVING = 100;

	public Categorie(String omschrijving, int snelheid, int kracht, int lenigheid) {
		setOmschrijving(omschrijving);
		setSnelheid(snelheid);
		setKracht(kracht);
		setLenigheid(lenigheid);
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	private void setOmschrijving(String omschrijving) {
        if(omschrijving == null || omschrijving.isBlank() || omschrijving.length() > MAX_LENGTE_OMSCHRIJVING)
            throw new IllegalArgumentException("Omschrijving moet ingevuld zijn en mag niet te lang zijn!");
        this.omschrijving = omschrijving;
	}

	public int getSnelheid() {
		return snelheid;
	}

	private void setSnelheid(int snelheid) {
        if(snelheid < MIN_SNELHEID)
            throw new IllegalArgumentException("Snelheid voldoet niet aan de domeinregels!");

        this.snelheid = snelheid;
	}

	public int getKracht() {
		return kracht;
	}

	private void setKracht(int kracht) {
        if(kracht < MIN_KRACHT || kracht > MAX_KRACHT)
            throw new IllegalArgumentException("Kracht voldoet niet aan de domeinregels!");

        this.kracht = kracht;
	}

	public int getLenigheid() {
		return lenigheid;
	}

	private void setLenigheid(int lenigheid) {
        if(lenigheid < MIN_LENINGHEID || lenigheid > MAX_LENINGHEID)
            throw new IllegalArgumentException("Lenigheid voldoet niet aan de domeinregels!");

        this.lenigheid = lenigheid;
	}
}
