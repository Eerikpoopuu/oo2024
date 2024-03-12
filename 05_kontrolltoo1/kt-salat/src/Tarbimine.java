public class Tarbimine {
    double kogus;

    ToiduInfo toiduInfo;

    public Tarbimine(int kogus, ToiduInfo toiduInfo) {
        this.kogus = kogus;
        this.toiduInfo = toiduInfo;
    }

    public double arvutaRasvakogus() {
        double rasvakogus = (kogus * toiduInfo.rasv)/ 100;
        return rasvakogus;
    }
}
