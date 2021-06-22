package ui;

import domein.Gebakje;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hr047
 */
public class GebakjeApplicatie2 {

    public static void main(String[] args) {
        String[] namen = {"aardbeientaartje", "eclair", "miserable", "hoorntje"};
        double[] eenheidsprijzen = {2.75, 1.5, 2, 1.75};
        Scanner scanner = new Scanner(System.in);

        Gebakje[] gebakjes = new Gebakje[namen.length];
        int[][] bestellingen = new int[3][gebakjes.length];

        for (int index = 0; index < gebakjes.length; index++) {
            gebakjes[index] = new Gebakje(namen[index], eenheidsprijzen[index]);
        }
        System.out.printf("Assortiment gebakjes: %s%n", Arrays.toString(gebakjes));

        //opvullen 2dim array bestellingen
        for (int klantrij = 0; klantrij < bestellingen.length; klantrij++) {
            System.out.printf("%nBestelling voor klant %d: %n", klantrij+1);
            for (int kolom = 0; kolom < bestellingen[klantrij].length; kolom++) {
                System.out.printf("Geef aantal voor %s: ", gebakjes[kolom]);
                bestellingen[klantrij][kolom] = scanner.nextInt();
            }
        }

        int[] totaalTeBakken = new int[gebakjes.length];
        int totaal;
        for (int kolom = 0; kolom < bestellingen[0].length; kolom++) {
            totaal = 0;
            for (int klantrij = 0; klantrij < bestellingen.length; klantrij++) {
                totaal += bestellingen[klantrij][kolom];
            }
            totaalTeBakken[kolom] = totaal;
        }

        int index = 0;
        System.out.printf("%nTotaal te bakken:%n");
        for (int aantal : totaalTeBakken) {
            if (aantal != 0) {
                System.out.printf("%d x %s%n", aantal, gebakjes[index].getNaam());
            }
            index++;
        }
        
    }

}
