package domein;

import java.util.List;
import java.util.ArrayList;

public class CategorieRepository
{
	private List<Categorie> categorieen;
	
	public CategorieRepository()
	{
		categorieen = new ArrayList<>();
		categorieen.add(new Categorie("Superheld", 350, 10, 5));
		categorieen.add(new Categorie("Mens", 10, 4, 2));
		categorieen.add(new Categorie("Dier", 100, 7, 3));
	}

	public List<Categorie> getCategorieen()
	{
		return categorieen;
	}
	
	public Categorie geefCategorie(String omschrijving)
	{
		for (Categorie c : categorieen)
			if (c.getOmschrijving().equals(omschrijving))
				return c;
		
		return null;
	}
	
	public void voegToe(Categorie categorie)
	{
		if (geefCategorie(categorie.getOmschrijving()) == null)
			categorieen.add(categorie);
	}
}
