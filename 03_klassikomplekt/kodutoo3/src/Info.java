public class Info {
    public Info(String mudel, int hind, int voimsus, int aasta, double labisoit) {
        this.mudel = mudel;
        this.hind = hind;
        this.voimsus = voimsus;
        this.aasta = aasta;
        this.labisoit = labisoit;
    }

    String mudel;
     int hind;
     int voimsus;
     int aasta;
      double labisoit;

    public void Labisoit(double uuslabisoit){
        labisoit = uuslabisoit;
    }
}
