package domein;

import java.util.ArrayList;
import java.util.List;

import dto.CategorieDTO;
import dto.PersonageDTO;

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
	
	public void maakCategorie(String omschrijving, int snelheid, int kracht, int lenigheid)
	{
		categorieRepo.voegToe(
		    new Categorie(omschrijving, snelheid, kracht, lenigheid));
	}
	
	public PersonageDTO geefDetailsPersonage()
	{
		if (huidigPersonage == null)
			return null;  //exception werpen
		
		Categorie personageCat = huidigPersonage.getCategorie();
		
		return new PersonageDTO(huidigPersonage.getNaam(), 
				personageCat.getOmschrijving(), 
				personageCat.getKracht(), personageCat.getSnelheid(), 
				personageCat.getLenigheid());
		
	}
		
	public List<String> geefPersonages()
	{
		List<String> personages = new ArrayList<>();
				
		for (Personage p : personageRepo.getPersonages())
		{
			personages.add(p.getNaam());
		}
		
		return personages;
	}

	public void selecteerPersonage(String naam)
	{
		huidigPersonage = personageRepo.geefPersonage(naam);
	}

	public List<CategorieDTO> geefCategorieen()
	{
		List<CategorieDTO> categorieen = new ArrayList<>();
		
		for (Categorie c : categorieRepo.getCategorieen())
			categorieen.add(new CategorieDTO(c.getOmschrijving(), c.getSnelheid(), c.getKracht(), c.getLenigheid()));
		
		return categorieen;
	}

	public void selecteerCategorie(String omschrijving)
	{
		huidigeCategorie = categorieRepo.geefCategorie(omschrijving);
	}

	public void registreerPersonage(String naam)
	{
		if (huidigeCategorie != null)
		{
			Personage personage = new Personage(naam, huidigeCategorie);
		}
	}

}
