package cui;

import domein.DomeinController;

public class DobbelspelApp
{
	private DomeinController dc;
	
	public DobbelspelApp(DomeinController dc)
	{
		this.dc = dc; // NOOIT dc = new DomeinController();
	}
	
	public void startSpel()
	{
		// hier komt de code die de flow beschrijft uit het SSD
		// hiervoor heb je een DomeinController-object nodig (eigen dc)
		
		dc.startNieuwSpel(); // 1e systeemoperatie
		
		while (!dc.isEindeSpel()) 
		{
			dc.rolDobbelstenen(); // 2e systeemoperatie
			System.out.println("Je rolde " + dc.geefAantalOgenWorp()); // 1e returnpijl
		}
		
		System.out.println("Je score is " + dc.geefScore()); // 2e returnpijl
	}
}
