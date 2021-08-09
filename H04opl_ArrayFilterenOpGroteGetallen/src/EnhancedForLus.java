
import java.util.Scanner;


public class EnhancedForLus
{
    public static void main(String args[])
    {
        int[] getallen = new int[10];
        int getal2;
        
        Scanner input = new Scanner(System.in);
        for (int index = 0; index < getallen.length; index++)
        {
            System.out.printf("Geef getal %d: ", index + 1);
            getallen[index] = input.nextInt();
        }
        System.out.print("Geef nog een getal:");
        getal2 = input.nextInt();
        
        System.out.printf("Deze getallen zijn strikt groter dan %d%n",
                getal2);
        String res = String.format("%10s%10s%n","Index","Waarde");
        
        int ind = 0;
        for(int g:getallen)
        {
            if (g > getal2)
                res += String.format("%10d%10d%n",ind,g);
            ind++;
        }
        System.out.print(res);
     }
}
