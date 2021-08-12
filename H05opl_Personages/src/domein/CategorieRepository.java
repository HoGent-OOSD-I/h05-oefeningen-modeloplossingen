package domein;

import java.util.List;
import java.util.ArrayList;

public class CategorieRepository
{
	private List<Categorie> categorieën;
	
	public CategorieRepository()
	{
		categorieën = new ArrayList<>();
		
		categorieën.add(new Categorie("Superheld", 350, 10, 5));
		categorieën.add(new Categorie("Mens", 10, 4, 2));
		categorieën.add(new Categorie("Dier", 100, 7, 3));
	}
	
	public void voegToe(Categorie categorie)
	{
		if (geefCategorie(categorie.getOmschrijving()) == null)
			categorieën.add(categorie);
	}
	
	public List<Categorie> getCategorieën()
	{
		return categorieën;
	}
	
	public Categorie geefCategorie(String omschrijving)
	{
		for (Categorie c : categorieën)
			if (c.getOmschrijving().equals(omschrijving))
				return c;
		
		return null;
	}
}
