package domein;

import java.util.*;

public class TrekkingRepository {

	private List<Trekking> trekkingen;
	
	public TrekkingRepository() {
		this.trekkingen = new ArrayList<>();
		//normaal komt de lijst van trekkingen uit de database
	}

	public void voegTrekkingToe(Trekking trekking) {
		if (geefTrekking(trekking.getNaam()) == null)
			trekkingen.add(trekking);
	}

    public List<Trekking> getTrekkingen(){
        return this.trekkingen;
    }

	public Trekking geefTrekking(String naam) {
		for(Trekking trek: this.trekkingen) {
			if(trek.getNaam().equals(naam))
				return trek;
		}
		return null;
	}

}