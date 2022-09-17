package domein;

import java.util.ArrayList;
import java.util.List;

public class TrekkingRepository {

	private List<Trekking> trekkingen;

	public TrekkingRepository() {
		trekkingen = new ArrayList<>();
	}

	public void voegTrekkingToe(String naam, List<Integer> nummers) {
		trekkingen.add(new Trekking(naam, nummers));
	}

	public Trekking geefTrekking(String naam) {
		for (Trekking trekking : trekkingen) {
			if (trekking.getNaam().equals(naam)) {
				return trekking;
			}
		}
		return null;
	}
}