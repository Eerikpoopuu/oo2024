import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Double> arvud = new ArrayList<>();
        arvud.add(4.0);
        arvud.add(7.0);
        arvud.add(5.0);
        List<Double> libisevadKeskmised = aruvtaKeskmine(arvud);
        System.out.println(libisevadKeskmised);
        keskmine keskmine1 = new keskmine(arvud);
        List<Double> libisevkeskmine2 = keskmine1.saaArvudKeskmine();
        System.out.println(libisevkeskmine2);
        keskmine1.lisaArv(10.0);
        List<Double> libisevKeskmine3 = keskmine1.saaArvudKeskmine();
        System.out.println(libisevKeskmine3);


    }

    private static List<Double> aruvtaKeskmine(List<Double>arvud) {
        List<Double> arvudKeskmised = new ArrayList<>();
        for (int i = 0; i < arvud.size() - 2; i++) {
            double summa = arvud.get(i) + arvud.get(i + 1) + arvud.get(i + 2);
            double libisevKeskmine = summa / 3;
            arvudKeskmised.add(libisevKeskmine);
        }
            return arvudKeskmised;





    }
}