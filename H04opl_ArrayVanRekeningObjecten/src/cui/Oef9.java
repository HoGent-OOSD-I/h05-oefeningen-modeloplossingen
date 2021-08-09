package cui;

import domein.Rekening;

public class Oef9 
{
	public static void main(String[] args) 
	{
		double[] bedragen = {100, 777.77, 287.15, -350, 399.99, 123.45, 987.65, -68.18, 413.26};
		final int aantalRekeningen = bedragen.length;
		Rekening[] rekeningen = new Rekening[aantalRekeningen];
		String houder, uitvoer = "";
		double saldo, gemiddelde = 0;
		
		for (int i=0; i<aantalRekeningen; i++)
		{
			houder = String.format("%c", 'A' + i);
			rekeningen[i] = new Rekening(i, houder);
			rekeningen[i].stortOp(bedragen[i]);
		}
		
		for (Rekening r: rekeningen)
		{
			saldo = r.getSaldo();
			uitvoer += String.format("Rekening %d van %s bevat %.2f%n", r.getRekeningnummer(), r.getHouder(), saldo);
			gemiddelde += saldo;
		}
		
		System.out.printf("%s%nHet gemiddelde saldo van deze %d rekeningen bedraagt: %.2f euro%n", uitvoer, aantalRekeningen, gemiddelde);
	}
}
