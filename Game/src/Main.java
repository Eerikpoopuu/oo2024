import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Maailm maailm = new Maailm(5,10);

        Mangija mangija = new Mangija(random, maailm.kaardiKorgus,maailm.kaardiLaius);
        Draakon draakon = new Draakon(random,maailm.kaardiKorgus,maailm.kaardiLaius);
        Ork ork = new Ork(random,maailm.kaardiKorgus,maailm.kaardiLaius);


//klass scanner
        Scanner scanner = new Scanner(System.in);//selgitab tunnis
        maailm.prindikaart(mangija, draakon, ork);
        String sisend = scanner.nextLine();

        mangija.liigu(sisend,maailm);


        while (!sisend.equals("end")) {
            maailm.prindikaart( mangija, draakon, ork);


            sisend = scanner.nextLine();
           mangija.liigu(sisend,maailm);
        }


    }//jäta



    private static int saakordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}