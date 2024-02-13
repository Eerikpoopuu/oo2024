import java.util.Random;

public class Draakon {
    int XCoord;
    int YCoord;
    char Symbol;

    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        XCoord =saakordinaat(random, kaardiKorgus);
        YCoord = saakordinaat(random, kaardiKorgus);
        Symbol = 'D';
    }


    private static int saakordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }

}
