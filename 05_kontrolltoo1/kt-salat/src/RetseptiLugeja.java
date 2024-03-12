import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RetseptiLugeja {
    public void loeRetsept(String failinimi) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(failinimi));
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
