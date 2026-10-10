package domein;

import dto.KaartDTO;

public class DomeinController {
	private HogerLager hogerLager;

	public void startHogerLager() {
		hogerLager = new HogerLager();
	}	
			
	public KaartDTO geefHuidigeKaart() {
		Kaart huidigeKaart = hogerLager.getHuidigeKaart();
		return new KaartDTO(huidigeKaart.getWaarde(), huidigeKaart.getKleur());
	}

	public void raadHogerLager(boolean hogerLager) {
		this.hogerLager.raadHogerLager(hogerLager);
	}

	public boolean isCorrectGeraden() {
		return hogerLager.isCorrectGeraden();
	}

	public boolean isEindeSpel() {
		return hogerLager.isEindeSpel();
	}

	public int geefScore() {
		return hogerLager.getScore();
	}

	public boolean isGewonnen() {
		return hogerLager.isGewonnen();
	}

}
