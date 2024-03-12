import java.util.ArrayList;
import java.util.List;

public class keskmine {
    List<Double> arvud = new ArrayList<>();

    List<Double> arvudKeskmised = new ArrayList<>();

    public keskmine(List<Double>algArvud){
      arvud = algArvud;
      aruvtaKeskmine();
    }

    public void lisaArv(double arv){
        double viimane = arvud.get(arvud.size()-1);
        double eelviimane = arvud.get(arvud.size()-2);
        arvud.add(arv);
        double keskmine = viimane + eelviimane+ arv/3;
        arvudKeskmised.add(keskmine);
    }
    public List<Double>saaArvudKeskmine(){
        return arvudKeskmised;
    }
    public List<Double> aruvtaKeskmine() {
        for (int i = 0; i < arvud.size() - 2; i++) {
            double summa = arvud.get(i) + arvud.get(i + 1) + arvud.get(i + 2);
            double libisevKeskmine = summa / 3;
            arvudKeskmised.add(libisevKeskmine);
        }
        return arvudKeskmised;





    }
}
