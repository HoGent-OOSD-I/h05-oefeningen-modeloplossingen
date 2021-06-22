package ui;

import domein.Gebakje;
import java.util.Arrays;
import java.util.Scanner;

public class GebakjeApplicatie1 {

    public static void main(String[] args) {
        String[] namen = {"aardbeientaartje", "eclair", "miserable", "hoorntje"};
        double[] eenheidsprijzen = {2.75, 1.5, 2, 1.75};
        Scanner scanner = new Scanner(System.in);

        Gebakje[] gebakjes = new Gebakje[namen.length];
        int[] bestelling = new int[gebakjes.length];

        for (int index = 0; index < gebakjes.length; index++) {
            gebakjes[index] = new Gebakje(namen[index], eenheidsprijzen[index]);
        }
        System.out.printf("Assortiment gebakjes: %s%n%n", Arrays.toString(gebakjes));

        double teBetalen = 0;
        for (int index = 0; index < gebakjes.length; index++) {
            System.out.printf("Geef aantal voor %s: ", gebakjes[index]);
            bestelling[index] = scanner.nextInt();
            teBetalen += bestelling[index] * gebakjes[index].getPrijs();

        }

        if (teBetalen == 0) {
            System.out.println("\nNiets besteld.");
        } else {
            System.out.println("\nDe bestelling :");
            int index = 0;
            for (int aantal : bestelling) {
                if (aantal != 0) {
                    System.out.printf("%d x %s%n", aantal, gebakjes[index].getNaam());
                }
                index++;
            }
            System.out.printf("kost €%.2f%n", teBetalen);
        }
    }



}
