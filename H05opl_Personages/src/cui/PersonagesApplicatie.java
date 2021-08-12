package cui;

import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class PersonagesApplicatie
{
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		DomeinController dc = new DomeinController();
		
		int keuze = maakKeuze(dc);
		
		while (keuze != 0)
		{
			switch (keuze)
			{
				case 1 -> maakCategorie(dc);
				case 2 -> maakPersonage(dc);
				case 3 -> selecteerPersonage(dc);
			}
			
			keuze = maakKeuze(dc);
		}
	}
	
	private static int maakKeuze(DomeinController dc)
	{
		System.out.println("MENU\n====");
		System.out.println("0. Afsluiten");
		System.out.println("1. Maak een nieuwe categorie");
		System.out.println("2. Maak een nieuw personage");
		System.out.println("3. Selecteer een personage");
		
		int keuze = -1;
		
		while (keuze < 0 || keuze > 3) {
			System.out.print("Maak een keuze: ");
			keuze = sc.nextInt();
		}
		
		return keuze;
	}
	
	private static void maakCategorie(DomeinController dc)
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
	
	private static void maakPersonage(DomeinController dc)
	{
		System.out.println("\nCATEGORIEEN\n===========");

		List<String> categorieën = dc.geefCategorieën();
		for (int i = 0; i < categorieën.size(); i++)
			System.out.printf("%d. %s%n", i + 1, categorieën.get(i));
		
		int categorieIndex = -1;

		while (categorieIndex < 0 || categorieIndex >= categorieën.size())
		{
			System.out.print("\nKies een categorie: ");
			categorieIndex = sc.nextInt() - 1;
		}

		dc.selecteerCategorie(categorieën.get(categorieIndex));
		
		System.out.print("\nGeef een naam voor het personage: ");
		String naam = sc.next();
		
		dc.registreerPersonage(naam);
		
		printDetailsPersonage(dc, true);
	}
	
	private static void selecteerPersonage(DomeinController dc)
	{
		System.out.println("\nPERSONAGES\n===========");

		List<List<String>> personages = dc.geefPersonages();
		for (int i = 0; i < personages.size(); i++)
			System.out.printf("%d. %s (%s)%n", i + 1, personages.get(i).get(0), personages.get(i).get(1));
		
		System.out.printf("%d. Maak een nieuw personage%n", personages.size() + 1);

		int personageIndex = -1;
		
		while (personageIndex < 0 || personageIndex > personages.size())
		{
			System.out.print("\nKies een Personage: ");
			personageIndex = sc.nextInt() - 1;
		}
		
		if (personageIndex == personages.size())
			maakPersonage(dc);
		else
		{
			dc.selecteerPersonage(personages.get(personageIndex).get(0));
			printDetailsPersonage(dc, false);
		}
	}
	
	private static void printDetailsPersonage(DomeinController dc, boolean isNieuwPersonage)
	{
		List<String> details = dc.geefDetailsPersonage();
		System.out.printf("\nJe %s dit personage:%n", isNieuwPersonage ? "maakte" : "selecteerde");
		System.out.printf("- Naam: %s%n", details.get(0));
		System.out.println("- Categorie:");
		System.out.printf("    - Omschrijving: %s%n", details.get(1));
		System.out.printf("    - Kracht: %s%n", details.get(2));
		System.out.printf("    - Snelheid: %s%n", details.get(3));
		System.out.printf("    - Lenigheid: %s%n%n", details.get(4));
	}
}
