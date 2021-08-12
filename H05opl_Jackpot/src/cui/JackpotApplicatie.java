package cui;

import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class JackpotApplicatie {

	public static void main(String[] args) {
		
		DomeinController dc = new DomeinController();

		dc.startNieuweJackpot();
		
		List<Integer> getallen = dc.geefGetallenWielen();
		System.out.print("Getallen op de wielen: ");
		for ( int getal   : getallen)
			System.out.printf("%d ", getal);
		
		Scanner invoer = new Scanner(System.in);
		System.out.printf("%nWil je met de jackpot spelen (ja=1, nee=0)? ");
		int verderSpelen = invoer.nextInt();
		
		while (verderSpelen!=0) {
			
			dc.speel();
			
			getallen = dc.geefGetallenWielen();
			System.out.printf("%nGetallen op de wielen: ");
			for ( int getal   : getallen)
				System.out.printf("%d ", getal);
			
			System.out.printf("%nDe score is %d", dc.geefScore());
			
			System.out.printf("%nWil je met de jackpot spelen (ja=1, nee=0)? ");
			verderSpelen = invoer.nextInt();
		}
		
		
	}

}
