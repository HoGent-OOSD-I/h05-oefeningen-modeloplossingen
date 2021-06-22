package ui;

import domein.Rekening;
import java.util.Scanner;

public class Oef12
{
    public static void main(String[] args)
    {
        Rekening rekeningen[][] = new Rekening[3][];
        Scanner input = new Scanner(System.in);
        int lengte;
        for(int i = 0; i < rekeningen.length;i++)
        {
            System.out.printf("Geef aantal kolommen in voor rij %d: ",i+1);
            lengte = input.nextInt();
            rekeningen[i]=new Rekening[lengte];
            for(int j = 0; j < rekeningen[i].length;j++)
            {
                rekeningen[i][j] = new Rekening();
                rekeningen[i][j].stortOp(10 * (j+1) + i);
            }
        }
        
        for(Rekening[] rij:rekeningen)//Rekening rekeningen[][]
        {
            for(Rekening rek:rij)
                System.out.printf("%-8.2f", rek.getSaldo());
            System.out.println();
        }
        
    }
}
