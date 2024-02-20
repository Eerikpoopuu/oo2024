import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Maailm maailm = new Maailm(5, 10);

        Mangija mangija = new Mangija(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Draakon draakon = new Draakon(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Ork ork = new Ork(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        List<Tegelane> tegelased = new ArrayList<>();
        tegelased.add(mangija);
        tegelased.add(draakon);
        tegelased.add(ork);

        Ese m66k = new Ese("M66k", 10, 1, random, maailm);
        Ese haamer = new Ese("Haamer", 5, 3, random, maailm);
        Ese saabas = new Ese("Saabas", 1, 5, random, maailm);
        List<Ese> esemed = new ArrayList<>();
        esemed.add(m66k);
        esemed.add(haamer);
        esemed.add(saabas);

        Soiduk auto = new Soiduk("auto",10,random,maailm);
        Soiduk ratas = new Soiduk("ratas",5,random,maailm);
        Soiduk rula = new Soiduk("rula", 2,random,maailm);
        List<Soiduk> soidukid = new ArrayList<>();
        soidukid.add(auto);
        soidukid.add(ratas);
        soidukid.add(rula);
//klass scanner
        Scanner scanner = new Scanner(System.in);//selgitab tunnis
        maailm.prindikaart(tegelased, esemed);
        String sisend = scanner.nextLine();

        mangija.liigu(sisend, maailm);


        while (!sisend.equals("end")) {
            maailm.prindikaart(tegelased, esemed);
            sisend = scanner.nextLine();
            mangija.liigu(sisend, maailm);
            for (Ese e : esemed) {
                if (mangija.XCoord == e.XCoord && mangija.YCoord == e.YCoord) {
                    mangija.ese = e;
                    System.out.println("Korjasid ules eseme: " + e.nimetus);
                    break;
                }

            }


        }//jäta


    }
}