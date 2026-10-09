package main;

import cui.JackpotApplicatie;
import domein.DomeinController;

public class StartUp {

	void main()	{
		DomeinController dc = new DomeinController();
		JackpotApplicatie jackpotApplicatie = new JackpotApplicatie(dc);
		jackpotApplicatie.startJackpotspel();
	}
}
