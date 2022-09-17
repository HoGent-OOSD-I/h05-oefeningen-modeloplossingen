package main;

import cui.JackpotApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args)
	{
		DomeinController dc = new DomeinController();
		JackpotApplicatie jackpotApplicatie = new JackpotApplicatie(dc);
		jackpotApplicatie.startJackpotspel();
	}
}
