import java.util.Random;

public class Draakon extends Tegelane implements JuhuslikKoordinaat {

    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        XCoord =saakordinaat(random, kaardiKorgus);
        YCoord = saakordinaat(random, kaardiKorgus);
        symbol = 'D';
    }


    public int saakordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }

}
