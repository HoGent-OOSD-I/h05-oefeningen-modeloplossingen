package domein;

import java.util.List;

public class DomeinController {

	private TrekkingRepository trekkingRepo;
	private Trekking geselecteerdeTrekking;

	public DomeinController() {
		trekkingRepo = new TrekkingRepository();
	}

	public void registreerTrekking(String naam, List<Integer> nummers) {
		trekkingRepo.voegTrekkingToe(new Trekking(naam, nummers));
	}

	public void selecteerTrekking(String naam) {
		geselecteerdeTrekking = trekkingRepo.geefTrekking(naam);
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

