//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Palk palk1 = new Palk ("eerik", "ehitaja", 2000);
        Palk palk2 = new Palk ("hannes","mahker",1500);

        System.out.println("uus tootaja:" + palk1.Nimi + " palk:" + palk1.palk );
        System.out.println("tootaja:" + palk2.Nimi+ " amet: " + palk2.Amet );

        Inimene inimene1 = new Inimene("Oskar", 75,180);
        Inimene inimene2 = new Inimene("Laur", 100,160);

        System.out.println("ulekaaline inimene "+ inimene2.Nimi +" ,kuna tema pikkus on " +inimene2.Pikkus);
        System.out.println(  inimene1.Nimi + "on");
        }
    }
