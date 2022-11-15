package cui;

import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import dto.PersonageDTO;

public class PersonagesApplicatie
{
	private Scanner sc = new Scanner(System.in);
	private DomeinController dc;

	public PersonagesApplicatie(DomeinController domeinController)
	{
		dc = domeinController;
	}

	public void start()
	{		
		int keuze = maakKeuze();
		
		while (keuze != 0)
		{
			switch (keuze)
			{
				case 1 -> maakCategorie();
				case 2 -> maakPersonage();
				case 3 -> selecteerPersonage();
			}
			
			keuze = maakKeuze();
		}
	}
	
	private int maakKeuze()
	{
		System.out.println("MENU\n====");
		System.out.println("0. Afsluiten");
		System.out.println("1. Maak een nieuwe categorie");
		System.out.println("2. Maak een nieuw personage");
		System.out.println("3. Selecteer een personage");
		
		int keuze;
		
		do
		{
			System.out.print("Maak een keuze: ");
			keuze = sc.nextInt();
		}while (keuze < 0 || keuze > 3);
		
		return keuze;
	}
	
	private void maakCategorie()
	{
		System.out.println("\nGeef de informatie voor de nieuwe categorie:");

		System.out.print("- omschrijving: ");
		String omschrijving = sc.next();

		System.out.print("- kracht (in interval [1, 10]): ");
		int kracht = sc.nextInt();
		
		System.out.print("- snelheid (> 0): ");
		int snelheid = sc.nextInt();

		System.out.print("- leningheid (in interval [1, 5]): ");
		int lenigheid = sc.nextInt();
		
		dc.maakCategorie(omschrijving, kracht, snelheid, lenigheid);
	}
	
	private void maakPersonage()
	{
		System.out.println("\nCATEGORIEEN\n===========");

		List<String> categorieen = dc.geefCategorieen();
		int i = 1;
		for (String categorie:categorieen)
			System.out.printf("%d. %s%n", i++ , categorie);
		
		int categorieIndex;

		do
		{
			System.out.print("\nKies een categorie: ");
			categorieIndex = sc.nextInt() - 1;
		}while (categorieIndex < 0 || categorieIndex >= categorieen.size());

		dc.selecteerCategorie(categorieen.get(categorieIndex));
		
		System.out.print("\nGeef een naam voor het personage: ");
		String naam = sc.next();
		
		dc.registreerPersonage(naam);
		
		printDetailsPersonage(true);
	}
	
	private void selecteerPersonage()
	{
		System.out.println("\nPERSONAGES\n===========");

		List<PersonageDTO> personages = dc.geefPersonages();
		int i = 1;
		for (PersonageDTO personage:personages)
			System.out.printf("%d. %s (%s)%n", i++, personage.naam(), personage.omschrijving());
		
		System.out.printf("%d. Maak een nieuw personage%n", personages.size() + 1);

		int personageIndex;
		
		do
		{
			System.out.print("\nKies een Personage: ");
			personageIndex = sc.nextInt() - 1;
		}while (personageIndex < 0 || personageIndex > personages.size());
		
		if (personageIndex == personages.size())
			maakPersonage();
		else
		{
			dc.selecteerPersonage(personages.get(personageIndex).naam());
			printDetailsPersonage(false);
		}
	}
	
	private void printDetailsPersonage(boolean isNieuwPersonage)
	{
		PersonageDTO personageDTO = dc.geefDetailsPersonage();
		System.out.printf("\nJe %s dit personage:%n", isNieuwPersonage ?
				"maakte" : "selecteerde");
		System.out.printf("- Naam: %s%n", personageDTO.naam());
		System.out.println("- Categorie:");
		System.out.printf("    - Omschrijving: %s%n", personageDTO.omschrijving());
		System.out.printf("    - Kracht: %s%n", personageDTO.kracht());
		System.out.printf("    - Snelheid: %s%n", personageDTO.snelheid());
		System.out.printf("    - Lenigheid: %s%n%n", personageDTO.lenigheid());
	}
}
