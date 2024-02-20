import java.util.Random;

public class Soiduk {
    String nimetus;
    int kiirus;
    int XCoord;
    int YCoord;
    char symbol;

    public Soiduk(String nimetus, int kiirus, Random random, Maailm maailm) {
        this.nimetus = nimetus;
        this.kiirus = kiirus;
        this.symbol = 'S';
        XCoord =saakordinaat(random, maailm.kaardiLaius);
        YCoord = saakordinaat(random, maailm.kaardiKorgus);
    }

    private static int saakordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }

}
