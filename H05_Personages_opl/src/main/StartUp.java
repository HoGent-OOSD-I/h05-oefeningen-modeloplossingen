package main;

import cui.PersonagesApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args)
	{
		PersonagesApplicatie personagesApplicatie = 
				new PersonagesApplicatie(new DomeinController());
		personagesApplicatie.start();
	}
}