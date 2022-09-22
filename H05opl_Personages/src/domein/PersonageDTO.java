package domein;

public record PersonageDTO(String naam, String omschrijving, int kracht, int snelheid, int lenigheid) {

	public PersonageDTO(String name, String omschrijving) {
		this(name, omschrijving, 0, 0, 0);
	}
}
