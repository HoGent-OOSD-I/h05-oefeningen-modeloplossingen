package domein;

import java.util.ArrayList;
import java.util.List;

public class PersonageRepository
{
	private List<Personage> personages;
	
	public PersonageRepository()
	{
		personages = new ArrayList<>();
	}
	
	public List<Personage> getPersonages()
	{
		return personages;
	}
	
	public Personage geefPersonage(String naam)
	{
		for (Personage p : personages)
			if (p.getNaam().equals(naam))
				return p;

		return null;
	}

	public Personage voegToe(String naam, Categorie categorie)
	{
		Personage personage = null;
		if (geefPersonage(naam) == null) {
			personage = new Personage(naam, categorie);
			personages.add(personage);	
		}
		return personage; 
	}

}

