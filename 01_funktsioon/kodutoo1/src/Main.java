//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //kolm funktsiooni, milles on kasutatud vähemalt 4erinavat tüüp
        // String;int,char,long,float
        //tagastab int
        //tagastab int
        //tagastab stringi näideks
        //teha igast funktsiooni 2 erineva sisendiga väljakutset
        double kaugus1 = arvutaKaugusMeetrites(5);
        System.out.println(kaugus1);
        double kaugus2 = arvutaKaugusMeetrites(3);
        System.out.println(kaugus2);

        String iqTest1 = tarkVoiLoll(102);
        System.out.println(iqTest1);
        String iqTest2 = tarkVoiLoll(60);
        System.out.println(iqTest2);

        double liida1 = Sum(3, 3.14f);
        System.out.println(liida1);
        double liida2 = Sum(23, 2.3f);
        System.out.println(liida2);
    }

    private static double arvutaKaugusMeetrites(int km) {
        return 1000 * km;
    }

    private static String tarkVoiLoll(double iq) {
        if (iq >= 100) {
            return "tark";
        } else {
            return "loll";
        }
    }

    private static float Sum(int a, float b) {
        return Math.round(a + b);
    }
}

