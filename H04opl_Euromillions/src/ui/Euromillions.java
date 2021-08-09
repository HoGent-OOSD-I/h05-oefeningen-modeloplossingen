package ui;

import java.security.SecureRandom;
import java.util.Arrays;

public class Euromillions 
{
    public static void main(String[] args) 
    {
        final int AANTALBALLEN = 5;
        final int AANTALSTERREN = 2;
        final int BOVENGRENSBALLEN = 50;
        final int BOVENGRENSSTERREN = 12;
        int[] euromillions = new int[AANTALBALLEN];
        int[] sterren = new int[AANTALSTERREN];
        String[] sterrenbeeld = {"Ram", "Leeuw", "Boogschutter", "Stier", "Maagd", "Steenbok", 
        						 "Tweelingen", "Weegschaal", "Waterman", "Kreeft", "Schorpioen", "Vissen"};

        int willekeurig;
        int i;
        SecureRandom sr = new SecureRandom();
        for (i = 0; i < euromillions.length; i++) 
        {
            willekeurig = sr.nextInt(BOVENGRENSBALLEN) + 1;
            euromillions[i] = willekeurig;

            for (int j = 0; j < i; j++) 
            {
                if (willekeurig == euromillions[j]) 
                {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(euromillions);
        System.out.printf("De getallen zijn %s", Arrays.toString(euromillions));
        
        for (i = 0; i < sterren.length; i++) 
        {
            willekeurig = sr.nextInt(BOVENGRENSSTERREN) + 1;
            sterren[i] = willekeurig;

            for (int j = 0; j < i; j++) 
            {
                if (willekeurig == sterren[j]) 
                {
                    i--;
                    break;
                }
            }
        }

        Arrays.sort(sterren);
        System.out.printf("%nDe sterren %s ", Arrays.toString(sterren));
        
        System.out.printf("%nHet sterrenbeeld = %s%n", sterrenbeeld[(int) (Math.random() * sterrenbeeld.length)]);
    }

}
