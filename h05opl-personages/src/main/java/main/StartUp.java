package main;

import cui.PersonagesApplicatie;
import domein.DomeinController;

public class StartUp {

	void main()	{
		PersonagesApplicatie personagesApplicatie = new PersonagesApplicatie(new DomeinController());
		personagesApplicatie.start();
	}
}