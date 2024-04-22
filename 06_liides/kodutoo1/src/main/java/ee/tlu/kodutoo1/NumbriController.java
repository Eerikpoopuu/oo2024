package ee.tlu.kodutoo1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NumbriController {
    List<Integer> numbrid = new ArrayList<>();

    @GetMapping("numbrid")
    public List<Integer> saanumbrid(){
        return numbrid;
    }
    @PostMapping("numbrid/{number}")
    public List<Integer> lisaNumbrid(@PathVariable Integer number){
        numbrid.add(number);
        return numbrid;
    }
    @DeleteMapping("numbrid/{index}")
    public List<Integer> kustutaNumbrid(@PathVariable int index){
        numbrid.remove(index);
        return numbrid;
    }
    @GetMapping("kokku")
    public int kokku(){
        return numbrid.size();
    }
    @GetMapping("summa")
    public int summa(){
        int summa = 0;
        for (int number : numbrid) {
            summa += number;
        }
        return summa;
    }
    @GetMapping("keskmine")
    public int keskmine(){
        int summa = 0;
        for (int number : numbrid) {
            summa += number;
        }
        return summa/numbrid.size();
    }



}
