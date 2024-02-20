public class Kasutaja {
    String nimi;
    boolean aktiivne;
    int vanus;
    char lyend;
    double raha;

    public Kasutaja(String nimi, boolean aktiivne, int vanus, char lyend, double raha) {
        this.nimi = nimi;
        this.aktiivne = aktiivne;
        this.vanus = vanus;
        this.lyend = lyend;
        this.raha = raha;
    }
    public double muudaAktiivne()
    {
        aktiivne= !aktiivne;
    }
    public double lisaRaha(double summa){
        raha =raha +summa;
        return raha;}
}
