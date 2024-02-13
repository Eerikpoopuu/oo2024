import java.util.Random;

public class Ork {
    int XCoord;
    int YCoord;
    char Symbol;

    public Ork(Random random, int kaardiKorgus, int kaardiLaius) {
        XCoord =saakordinaat(random, kaardiKorgus);
        YCoord = saakordinaat(random, kaardiKorgus);
        Symbol = 'O';
    }
    private static int saakordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }

}
