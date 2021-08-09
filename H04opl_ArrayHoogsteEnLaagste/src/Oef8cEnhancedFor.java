
public class Oef8cEnhancedFor
{
    public static void main(String args[])
    {
        int[] omzetten = {360, 2100, 450, 1450, 650, 780, 321, 1200, 560, 1850, 960, 420};
        int kl = omzetten[0], gr = omzetten[0], grMaand = 1, klMaand = 1;
        int ind = 1;
        for(int omzet: omzetten)
        {
            if (omzet < kl)
            {
                kl = omzet;
                klMaand = ind;
            }

            if (omzet > gr)
            {
                gr = omzet;
                grMaand = ind;
            }
            ind++;
        }
        System.out.printf("Hoogste omzet %d in maand %d%n",gr,grMaand);
        System.out.printf("Laagste omzet %d in maand %d%n",kl,klMaand);


    }
}
