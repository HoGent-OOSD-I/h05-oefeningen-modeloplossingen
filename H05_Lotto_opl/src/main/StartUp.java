package main;

import cui.LottoApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		LottoApplicatie lottoApplicatie = 
				new LottoApplicatie(new DomeinController());
		lottoApplicatie.startLotto();
	}
}
