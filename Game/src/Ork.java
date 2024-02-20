import java.util.Random;

public class Ork extends Tegelane implements JuhuslikKoordinaat {

    public Ork(Random random, int kaardiKorgus, int kaardiLaius) {
        XCoord =saakordinaat(random, kaardiKorgus);
        YCoord = saakordinaat(random, kaardiKorgus);
        symbol = 'O';
    }
    public int saakordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }

}
