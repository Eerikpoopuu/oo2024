package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToiduaineController {


    List<String> toiduained = new ArrayList<>();//imiteerime andmebaasi
    //localhost:8080/saa-toiduained
    @GetMapping("toiduained")
    public List<String> saaToiduained(){
        return toiduained;
    }
    //Postmappingut ei saa brauser teha
    //localhost:8080/toiduained/KArtul Post
    @PostMapping("toiduained/{toiduaine}")
    public List<String> lisaToiduaine(@PathVariable String toiduaine){
        toiduained.add(toiduaine);
        return toiduained;
    }
    @DeleteMapping("toiduained/{index}")
    public List<String> kustutaToiduaine(@PathVariable int index){
        toiduained.remove(index);
        return toiduained;
    }
    //localhost:8080/0/vorst
    @PutMapping("toiduained/{index}/{newValue}")
    public List<String> muudaToiduaine(@PathVariable int index,@PathVariable String newValue){
        toiduained.set(index,newValue);
        return toiduained;
    }

    @GetMapping("toiduained/{index}")
    public String saaYksToiduaine(@PathVariable int index){
        return toiduained.get(index);
    }

    @GetMapping("tere")
    public String hello(){
        return "Tere";
    }
}
