
import java.util.Scanner;

public class Oef11
{
    public static void main(String arg[])
    {
        double table[][] = new double[3][2]; //3 rijen, 2 kolommen
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < table.length;i++)//rijen
            for(int j = 0;j < table[i].length;j++)
            {
                System.out.printf("Geef getal op rij %d en kolom %d: ",i+1,j+1);
                table[i][j] = input.nextDouble();
            }
        double gem;
        double som = 0;
        int aantalGetn = 0;
        for(double[] rij :table)//int[][] table
        {
            
            for(double getal:rij)
            {
                som += getal;
            //    aantalGetn++;
            }
            aantalGetn += rij.length; // beter: rij per rij aantal elementen optellen
        }
        gem = som/aantalGetn;
        String uitvoer = String.format("gemiddelde is %.1f%n", gem);
        System.out.printf(uitvoer);
    } //einde methode main

}
