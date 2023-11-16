package domein;

import java.time.LocalDate;
import java.util.List;

import dto.TrekkingDTO;

public class DomeinController {

	private TrekkingRepository trekkingRepo;
	private Trekking geselecteerdeTrekking;

	public DomeinController() {
		trekkingRepo = new TrekkingRepository();
	}

	public void registreerTrekking(String naam, LocalDate datum, List<Integer> nummers) {
		trekkingRepo.voegTrekkingToe(new Trekking(naam, datum, nummers));
	}

	public void selecteerTrekking(String naam) {
		geselecteerdeTrekking = trekkingRepo.geefTrekking(naam);
	}
	
	public TrekkingDTO geefTrekking() {
		if(geselecteerdeTrekking != null)
			return new TrekkingDTO(geselecteerdeTrekking.getNaam(), 
					geselecteerdeTrekking.getDatum());
		return null;
	}

	public int geefWinst(List<Integer> nummers) {
		if (geselecteerdeTrekking == null)
			return 0;
		return geselecteerdeTrekking.geefWinst(nummers);
	}

	public int aantalNummers() {
		return Trekking.AANTAL_NUMMERS;
	}

}

