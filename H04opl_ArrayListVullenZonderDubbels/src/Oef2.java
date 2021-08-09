import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Oef2
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		List<Integer> cijfers = new ArrayList<>();
		int invoer, deler, eenheid;
		String uitvoer = "";

		do
		{
			System.out.print("Geef een getal van 8 cijfers: ");
			invoer = s.nextInt();
		}
		while (invoer < 10000000 || invoer > 99999999);

		deler = 10000000;
		do
		{
			eenheid = invoer / deler;
			invoer %= deler;
			deler /= 10;

			if (!cijfers.contains(eenheid))
				cijfers.add(eenheid);
		}
		while (deler > 0);

		System.out.println("Alle verschillende cijfers in dit getal (in volgorde van voorkomen) zijn: ");
		for (int cijfer : cijfers)
			uitvoer += String.format("%2d", cijfer);

		System.out.println(uitvoer);
	}
}
