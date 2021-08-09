
public class Oef6GewoneFor
{
    public static void main(String args[])
    {
        int[] omzetten = {360, 2100, 450, 1450, 650, 780, 321, 1200, 560, 1850, 960, 420};
        int kl = omzetten[0], gr = omzetten[0], grMaand = 1, klMaand = 1;

        for(int ind = 1; ind < omzetten.length; ind++)
        {
            if (omzetten[ind] < kl)
            {
                kl = omzetten[ind];
                klMaand = ind;
            }

            if (omzetten[ind] > gr)
            {
                gr = omzetten[ind];
                grMaand = ind;
            }
        }
        System.out.printf("Hoogste omzet %d in maand %d%n",gr,grMaand);
        System.out.printf("Laagste omzet %d in maand %d%n",kl,klMaand);


    }
}
