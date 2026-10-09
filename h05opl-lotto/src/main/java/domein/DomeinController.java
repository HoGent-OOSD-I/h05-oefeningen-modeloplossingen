package domein;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<TrekkingDTO> geefAlleTrekkingen() {
        List<Trekking> trekkingen = trekkingRepo.getTrekkingen();
        List<TrekkingDTO> dtos = new ArrayList<>();

        for(Trekking trekking: trekkingen) {
            dtos.add(zetTrekkingOmNaarDTO(trekking));
        }
        return dtos;
    }

	public void selecteerTrekking(String naam) {
		geselecteerdeTrekking = trekkingRepo.geefTrekking(naam);
	}
	
	public TrekkingDTO geefDetailsGeseleteerdeTrekking() {
        if (geselecteerdeTrekking == null)
            throw new IllegalArgumentException("Geen (geldige) trekking geselecteerd!");
        return zetTrekkingOmNaarDTO(geselecteerdeTrekking);
	}

	public int geefWinst(List<Integer> nummers) {
		if (geselecteerdeTrekking == null)
			throw new IllegalArgumentException("Geen (geldige) trekking geselecteerd!");
		return geselecteerdeTrekking.geefWinst(nummers);
	}

	public int geefAantalNummers() {
		return Trekking.AANTAL_NUMMERS;
	}

    private TrekkingDTO zetTrekkingOmNaarDTO(Trekking t){
        return new TrekkingDTO(t.getNaam(), t.getDatum());
    }
}

