package domein;

public class DomeinController
{
	private HogerLager hl;
	private boolean correctGeraden;

	public void startHogerLager()
	{
		hl = new HogerLager();
	}

	public int geefHuidigeKaart()
	{
		return hl.geefWaardeHuidigeKaart();
	}

	public void raadHogerLager(boolean hogerLager)
	{
		correctGeraden = hl.raadHogerLager(hogerLager);
	}

	public boolean isCorrectGeraden()
	{
		return correctGeraden;
	}

	public boolean isEindeSpel()
	{
		return hl.isEindeSpel();
	}

	public int geefScore()
	{
		return hl.getScore();
	}

	public boolean isGewonnen()
	{
		return hl.isGewonnen();
	}
}
