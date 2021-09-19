package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController
{
	private CategorieRepository categorieRepo;
	private PersonageRepository personageRepo;
	private Categorie huidigeCategorie;
	private Personage huidigPersonage;
	
	public DomeinController()
	{
		categorieRepo = new CategorieRepository();
		personageRepo = new PersonageRepository();
	}
	
	public void maakCategorie(String omschrijving, int kracht, int snelheid, int lenigheid)
	{
		categorieRepo.voegToe(new Categorie(omschrijving, snelheid, kracht, lenigheid));
	}

	public List<String> geefCategorieën()
	{
		List<String> categorieën = new ArrayList<>();
		
		for (Categorie c : categorieRepo.getCategorieën())
			categorieën.add(c.getOmschrijving());
		
		return categorieën;
	}
	
	public void selecteerCategorie(String omschrijving)
	{
		huidigeCategorie = categorieRepo.geefCategorie(omschrijving);
	}
	
	public List<String> geefDetailsPersonage()
	{
		List<String> details = new ArrayList<>();
		
		if (huidigPersonage != null)
		{
			details.add(huidigPersonage.getNaam());

			Categorie personageCat = huidigPersonage.getCategorie();
			details.add(personageCat.getOmschrijving());
			details.add(String.format("%d", personageCat.getKracht()));
			details.add(String.format("%d", personageCat.getSnelheid()));
			details.add(String.format("%d", personageCat.getLenigheid()));
		}
		
		return details;
	}
	
	public void registreerPersonage(String naam)
	{
		huidigPersonage = new Personage(naam, huidigeCategorie);
		personageRepo.voegToe(huidigPersonage);
	}
	
	public List<List<String>> geefPersonages()
	{
		List<List<String>> personages = new ArrayList<>();
		List<String> personageLijst;
		
		for (Personage p : personageRepo.getPersonages())
		{
			personageLijst = new ArrayList<>();
			personageLijst.add(p.getNaam());

			Categorie personageCat = p.getCategorie();
			personageLijst.add(personageCat.getOmschrijving());
			
			personages.add(personageLijst);
			
		}
		
		return personages;
	}
	
	public void selecteerPersonage(String naam)
	{
		huidigPersonage = personageRepo.geefPersonage(naam);
	}
}
