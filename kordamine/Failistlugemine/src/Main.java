import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ssd.txt"));
         String rida = br.readLine();
         while (rida != null){
             System.out.println(rida);
               String[] sonad = rida.split(" ");
             System.out.println(sonad);
             rida=br.readLine();
         }
    }
}