package domein;

public class Rekening
{
    private long rekeningnummer;
    private double saldo;
    private String houder;

    public Rekening()
    {
        setRekeningnummer(123456789);
        setHouder("onbekend");
    }

    public Rekening(long rekeningnummer)
    {
        setRekeningnummer(rekeningnummer);
        setHouder("onbekend");
    }

    public Rekening(long rekeningnummer, String houder)
    {
        setRekeningnummer(rekeningnummer);
        setHouder(houder);
    }

    private void setRekeningnummer(long rekeningnummer)
    {
        this.rekeningnummer = rekeningnummer;
    }

    public long getRekeningnummer()
    {
        return rekeningnummer;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public final void setHouder(String houder)
    {
        this.houder = houder;
    }

    public String getHouder()
    {
        return houder;
    }

    public void stortOp(double bedrag)
    {
        saldo += bedrag; 
    }
}
