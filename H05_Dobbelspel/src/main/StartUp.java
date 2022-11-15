package main;

import cui.DobbelspelApplicatie;
import domein.DomeinController;

public class StartUp
{
	public static void main(String[] args)
	{
		DomeinController dc = new DomeinController();
		DobbelspelApplicatie da = new DobbelspelApplicatie(dc);
		da.startSpel();
	}

}
