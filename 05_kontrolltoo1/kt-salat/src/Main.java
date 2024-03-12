import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ToiduInfo kartul = new ToiduInfo("kartul", 10, 5, 12);
        ToiduInfo porgand = new ToiduInfo("porgand", 5, 7, 7);

        Tarbimine kartuliTarbimine = new Tarbimine(100, kartul);
        Tarbimine porgandiTarbimine = new Tarbimine(50, porgand);
        System.out.println(kartuliTarbimine.arvutaRasvakogus());
        Toit kartulisalat = new Toit("kartulisalat");
        kartulisalat.koostisosad.add(kartuliTarbimine);
        kartulisalat.koostisosad.add(porgandiTarbimine);

        for (Tarbimine komponent : kartulisalat.koostisosad) {
            System.out.println(komponent.kogus + " g " + komponent.toiduInfo.nimi);
        }
        double valgud = kartulisalat.leiaValk();
        double rasvad = kartulisalat.leiaRasvad();
        double susivesikud = kartulisalat.leiaSusivesikud();
        System.out.println(valgud);
        System.out.println(rasvad);
        System.out.println(susivesikud);


        try {
            FileWriter fileWriter = new FileWriter("retseptid.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Retsept: " + kartulisalat.nimi);
            bufferedWriter.newLine();
            bufferedWriter.write("Koostisosad:");
            bufferedWriter.newLine();
            for (Tarbimine komponent : kartulisalat.koostisosad) {
                bufferedWriter.write("- " + komponent.kogus + " g " + komponent.toiduInfo.nimi);
                bufferedWriter.newLine();
                bufferedWriter.write(" (Valk: " + komponent.toiduInfo.valk + "g, Rasv: " + komponent.toiduInfo.rasv + "g, Süsivesikud: " + komponent.toiduInfo.susivesikud + "g)");
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Kogus: ");
            bufferedWriter.newLine();
            bufferedWriter.write("Valk: " + kartulisalat.leiaValk() + " g");
            bufferedWriter.newLine();
            bufferedWriter.write("Rasv: " + kartulisalat.leiaRasvad() + " g");
            bufferedWriter.newLine();
            bufferedWriter.write("Süsivesikud: " + kartulisalat.leiaSusivesikud() + " g");
            bufferedWriter.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


            try {
                BufferedReader reader = new BufferedReader(new FileReader("retseptid.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // Prindime iga rea välja
                }
                reader.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }



}
