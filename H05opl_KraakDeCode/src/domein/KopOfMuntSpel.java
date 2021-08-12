package domein;

import java.security.SecureRandom;

public class KopOfMuntSpel {

	private String code;
	private int moeilijkheidsgraad;
	
	public KopOfMuntSpel(int moeilijkheidsgraad) {
		
		setMoeilijkheidsgraad(moeilijkheidsgraad);
		// lokale variabele code heeft voorrang op attribuut
		String code = genereerCode();
		setCode(code);	
		
		// setCode(genereerCode());
	}
	
	private String genereerCode() {
		
		String resultaat = "";
		SecureRandom sr = new SecureRandom();
		char kopOfMunt;

		for (int i=1; i<=(moeilijkheidsgraad==1?3:4); i++) {
			
			kopOfMunt = sr.nextInt(2)==0?'K':'M';
			resultaat += String.format("%c", kopOfMunt);
			
			
/*			resultaat = "";	//  ""
			resultaat += "K";  // "" + "K" = "K"
			resultaat += "M";  // "K" + "M" = "KM"
			
			String test = String.format("De som is %d", 5);   // test = "De som is 5"
*/		
		}
		return resultaat;
		
	}

	public boolean isGeraden(String geradenCode) {
		return geefScore(geradenCode)==(moeilijkheidsgraad==1?3:4);
	}
	
	public int geefScore(String geradenCode) {
	
		int score = 0;
		
		for (int i=0; i<(moeilijkheidsgraad==1?3:4); i++) {
			
			if (code.charAt(i) == geradenCode.charAt(i))
				score++;
		}
		
		return score;
	}
	
	public String getCode() {
		return code;
	}

	private void setCode(String code) {
		this.code = code;
	}

	public int getMoeilijkheidsgraad() {
		return moeilijkheidsgraad;
	}

	private void setMoeilijkheidsgraad(int moeilijkheidsgraad) {
		if (moeilijkheidsgraad == 1 || moeilijkheidsgraad == 2)
			this.moeilijkheidsgraad = moeilijkheidsgraad;
		else
			this.moeilijkheidsgraad = 1;
	}
	
	
}
