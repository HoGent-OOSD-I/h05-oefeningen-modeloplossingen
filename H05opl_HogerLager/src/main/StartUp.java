package main;

import cui.HogerLagerApp;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		HogerLagerApp hogerLagerApp = new HogerLagerApp(new DomeinController());
		hogerLagerApp.startHogerLagerSpel();
	}
}
