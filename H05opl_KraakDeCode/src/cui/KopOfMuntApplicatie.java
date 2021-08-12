package cui;

import java.util.Scanner;
import domein.DomeinController;

public class KopOfMuntApplicatie {

	public static void main(String[] args) {
		
		DomeinController dc = new DomeinController();
		Scanner invoer = new Scanner(System.in);
		int moeilijkheidsgraad;
		
		do {
			System.out.print("Geef de moeilijkheidsgraad van het spel dat je wil spelen (1=gemakkelijk, 2=normaal):" );
			moeilijkheidsgraad = invoer.nextInt();
		}while(moeilijkheidsgraad !=1 && moeilijkheidsgraad != 2);
		
		dc.maakSpel(moeilijkheidsgraad);

//		even code uitschrijven om te controleren of het raden klopt
//		for (String s : dc.geefSpelInfo())  
//			System.out.println(s);
		
		System.out.print("Doe een poging om de code te kraken: ");
		String code = invoer.next();
		
		while (!dc.isGeraden(code)) {
			
			System.out.printf("Jouw code %s levert een score van %d op.%n", code, dc.geefScore(code));
			
			System.out.print("Doe een poging om de code te kraken: ");
			code = invoer.next();
		}
		
		System.out.println("Hoera! Je hebt de code gekraakt.");
		
		
		for (String s : dc.geefSpelInfo())
			System.out.println(s);

	}

}
