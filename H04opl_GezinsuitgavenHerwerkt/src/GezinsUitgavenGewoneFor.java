/*Opgave : Voer voor alle maanden van het jaar de gezinsuitgaven in.
 Bereken het maandgemiddelde en druk het nummer af van die maanden, 
waarvan de uitgaven groter zijn dan het gemiddelde.

 Oplossing : Pas na de bepaling van het gemiddelde kan nagegaan worden
 of de uitgaven voor een bepaalde maand groter zijn dan het gemiddelde of niet.
 Vandaar dat er 12 variabelen nodig zijn om de maandelijkse gezinsuitgaven bij te houden.

 Herwerk deze oefening en maak gebruik van een array!
 */
import java.util.Scanner;

public class GezinsUitgavenGewoneFor
{

    public static void main(String args[])
    {
        String result = "";
        double[] m = new double[12];
        double gem = 0;
        Scanner input = new Scanner(System.in);
     
        for (int i=0; i<m.length; i++)
        {
        	System.out.printf("Geef de uitgaven in voor maand %d : ", i+1);
        	m[i] = input.nextDouble();
        	gem += m[i];
        }
              
        gem /= 12;
                 
        for (int i=0; i<m.length; i++)
        {
        	if (m[i] > gem)
        	{
        		result += String.format("%d ", i+1);
        	}
        }
        
        if (!result.equals(""))
        {
            System.out.printf("In de volgende maanden werd een omzet behaald groter dan het gemiddelde: %s%n", result);
        } else
        {
            System.out.printf("Geen maanden gevonden die meer omzet hebben dan het gemiddelde!%n");
        }
    }
}