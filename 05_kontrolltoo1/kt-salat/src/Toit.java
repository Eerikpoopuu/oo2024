import java.util.ArrayList;

public class Toit {
    String nimi;
    ArrayList<Tarbimine> koostisosad;

    public Toit(String nimi) {
        this.nimi = nimi;
        koostisosad = new ArrayList<>();
    }

    public double leiaValk() {
        double summa = 0;
        for (Tarbimine komponent : koostisosad) {
            summa += (komponent.kogus * komponent.toiduInfo.valk) / 100.0;
        }
        return summa;
    }

    // Meetod rasvade koguse leidmiseks
    public double leiaRasvad() {
        double summa = 0;
        for (Tarbimine komponent : koostisosad) {
            summa += komponent.arvutaRasvakogus();
        }
        return summa;
    }

    // Meetod süsivesikute koguse leidmiseks
    public double leiaSusivesikud() {
        double summa = 0;
        for (Tarbimine komponent : koostisosad) {
            summa += (komponent.kogus * komponent.toiduInfo.susivesikud) / 100.0;
        }
        return summa;

    }
}
