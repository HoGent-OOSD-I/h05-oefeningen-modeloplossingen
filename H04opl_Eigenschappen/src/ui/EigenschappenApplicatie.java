package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EigenschappenApplicatie 
{
	public static void main(String[] args) 
	{
		Scanner invoer = new Scanner(System.in);
		List<String> posEign, negEign;
		int positief;
		String alleEign;

		posEign = new ArrayList<>();
		negEign = new ArrayList<>();
		  
		for (int i=1; i<=3; i++)
		{
			do 
			{
				System.out.println("Is het een positieve (=1) of negatieve (=2) eigenschap?");
				positief = invoer.nextInt(); 
			} while (positief != 1 && positief != 2); 
			
			invoer.nextLine();

			System.out.println("Omschrijf deze eigenschap:");
			String omschrijving = invoer.nextLine();

			List<String> welke = positief == 1 ? posEign : negEign;
			welke.add(omschrijving);
		}	
		
		if (posEign.isEmpty())
			System.out.println("Geen positieve eigenschappen");
		else
		{
			alleEign = "";
			for (String eig : posEign)
				alleEign += String.format("%s%s", alleEign.isEmpty() ? "" : ", ", eig);
			System.out.println("Positieve eigenschappen: " + alleEign);
		}
		
		if (negEign.isEmpty())
			System.out.println("Geen negatieve eigenschappen");
		else
		{
			alleEign = "";
			for (String eig : negEign)
				alleEign += String.format("%s%s", alleEign.isEmpty() ? "" : ", ", eig);
			System.out.println("Negatieve eigenschappen: " + alleEign);
		}
		
	}
}