package main;

import cui.LottoApplicatie;
import domein.DomeinController;

public class StartUp {

	void main() {
		LottoApplicatie lottoApplicatie = new LottoApplicatie(new DomeinController());
		lottoApplicatie.startLotto();
	}
}
