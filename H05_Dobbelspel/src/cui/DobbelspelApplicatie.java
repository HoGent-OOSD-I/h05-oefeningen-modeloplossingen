package cui;

import domein.DomeinController;

public class DobbelspelApplicatie
{
	private DomeinController dc;
	
	public DobbelspelApplicatie(DomeinController dc)
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
			System.out.printf("Je rolde %d%n", dc.geefAantalOgenWorp()); // 1e returnpijl
		}
		
		System.out.printf("Je score is %d%n", dc.geefScore()); // 2e returnpijl
	}
}
