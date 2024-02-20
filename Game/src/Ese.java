import java.util.Random;

public class Ese {
    String nimetus;
    double tugegus;
    int kasutuskorrand;
    boolean aktiivne;
    int XCoord;
    int YCoord;
    char symbol;

    public Ese(String nimetus, double tugegus, int kasutuskorrand, Random random, Maailm maailm) {
        this.nimetus = nimetus;
        this.tugegus = tugegus;
        this.kasutuskorrand = kasutuskorrand;
        this.aktiivne = true;
        this.symbol = 'I';
        XCoord =saakordinaat(random, maailm.kaardiLaius);
        YCoord = saakordinaat(random, maailm.kaardiKorgus);
    }
    public void hit(){
        System.out.println("Loid vastast!");
    }
    private static int saakordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}





