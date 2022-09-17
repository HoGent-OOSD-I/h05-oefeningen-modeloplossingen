package main;

import cui.DobbelspelApp;
import domein.DomeinController;

public class StartUp
{
	
	public static void main(String[] args)
	{
		DomeinController dc = new DomeinController();
		DobbelspelApp da = new DobbelspelApp(dc);
		da.startSpel();
	}

}
