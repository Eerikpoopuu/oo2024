public class ToiduInfo {
    String nimi;
    int valk;
    int rasv;
     int susivesikud;

    public ToiduInfo(String nimi, int valk, int rasv, int susivesikud) {
        this.nimi = nimi;
        this.valk = valk;
        this.rasv = rasv;
        this.susivesikud = susivesikud;
    }

    public double getRasv() {
        return rasv;
    }


}
