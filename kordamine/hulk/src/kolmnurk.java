import java.util.List;

public class kolmnurk {


   List<Integer> xCoord;
    List<Integer> yCoord;

    public kolmnurk(List<Integer> xCoord, List<Integer> yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

public int lisaCoord(int newXCoord, int newYCoord){
        xCoord.add(newXCoord);
        yCoord.add(newYCoord);

        int summa = 0;
        for (int x: xCoord){
            summa += x;
        }
        return summa;
}
}
