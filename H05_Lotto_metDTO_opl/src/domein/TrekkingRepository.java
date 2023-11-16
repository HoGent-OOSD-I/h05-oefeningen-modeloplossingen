package domein;

import java.util.*;

public class TrekkingRepository {

	private List<Trekking> trekkingen;
	
	public TrekkingRepository() {
		this.trekkingen = new ArrayList<>();
		//normaal komt de lijst van trekkingen uit de database
	}

	/**
	 * 
	 * @param trekking
	 */
	public void voegTrekkingToe(Trekking trekking) {
		this.trekkingen.add(trekking);
	}

	/**
	 * 
	 * @param naam
	 */
	public Trekking geefTrekking(String naam) {
		for(Trekking trek: this.trekkingen) {
			if(trek.getNaam().equals(naam))
				return trek;
		}
		return null;
	}

}