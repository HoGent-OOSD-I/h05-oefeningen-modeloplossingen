package main;

import cui.HogerLagerApplicatie;
import domein.DomeinController;

public class StartUp {

	void main() {
		HogerLagerApplicatie hogerLagerApp = 
				new HogerLagerApplicatie(new DomeinController());
		hogerLagerApp.startHogerLagerSpel();
	}
}
