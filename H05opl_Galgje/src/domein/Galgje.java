package domein;

public class Galgje {

	private GeheimWoord geheimWoord;
	private String reedsGeradenLetters;
	private int aantalMissers;

	public Galgje(GeheimWoord geheimWoord) {
		this.geheimWoord = geheimWoord;
		reedsGeradenLetters = "";
		aantalMissers = 0;
	}

	public void verwerkLetter(char letter) {
		if (geheimWoord.bevatLetter(letter))
			reedsGeradenLetters += letter;
		else
			aantalMissers++;
	}

	public String geefGemaskeerdWoord() {
		String gemaskeerdWoord = "";
		String gezochteWoord = geheimWoord.getGezochteWoord();
		for (int index = 0; index < gezochteWoord.length(); index++) {
			if (reedsGeradenLetters.indexOf(gezochteWoord.charAt(index)) != -1)
				gemaskeerdWoord += gezochteWoord.charAt(index);
			else
				gemaskeerdWoord += "*";
		}
		return gemaskeerdWoord;
	}

	public boolean isWoordGeraden() {
		return geefGemaskeerdWoord().indexOf('*') == -1;
	}

	public int geefScore() {
		return Math.max(geheimWoord.getWaarde() - aantalMissers, 0);
	}

	public boolean isGedaan() {
		return isWoordGeraden() || aantalMissers == 10;
	}

	public String geefGezochteWoord() {
		return geheimWoord.getGezochteWoord();
	}

	public int getAantalMissers() {
		return aantalMissers;
	}
}
