package main;

import cui.HogerLagerApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		HogerLagerApplicatie hogerLagerApp = new HogerLagerApplicatie(new DomeinController());
		hogerLagerApp.startHogerLagerSpel();
	}
}
