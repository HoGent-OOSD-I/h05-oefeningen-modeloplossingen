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

	public boolean voegToe(Personage personage)
	{
		if (geefPersonage(personage.getNaam()) == null) {
			personages.add(personage);	
			return true;
		}
		return false; 
	}

}

