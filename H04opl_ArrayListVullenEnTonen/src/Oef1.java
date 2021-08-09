import java.util.*;

public class Oef1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double getal;
        List<Double> deLijst = new ArrayList<>();
        System.out.print("Geef een positief bedrag, stop met -1: ");
        getal = input.nextDouble();
        while(getal != -1)
        {
        	if (getal >= 0)
        		deLijst.add(getal);
            System.out.print("Geef een positief bedrag, stop met -1: ");
            getal = input.nextDouble();
        }
        if(deLijst.isEmpty())
            System.out.println("De lijst is leeg!");
        else
        {
        	System.out.print("De lijst met bedragen: ");
            for(double get:deLijst)
                System.out.printf("%8.2f",get);
            System.out.println();
        }
    }      
}
