package ee.tlu.kodutoo1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class AutoEntityController {

    //List<AutoEntity> autod = new ArrayList<>();
    AutoRepository autoRepository;

    public AutoEntityController(AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }

    @GetMapping("auto")
    public List<AutoEntity> saaautod() {
        return autoRepository.findAll();
    }

    @PostMapping("autod/{nimi}/{hind}/{hobuj6ud}")
    public List<AutoEntity> lisaAuto
            (@PathVariable String nimi,
             @PathVariable Integer hind,
             @PathVariable Integer hobuj6ud) {

        AutoEntity auto = new AutoEntity(nimi, hind, hobuj6ud);
        autoRepository.save(auto);
        return autoRepository.findAll();
    }

    @DeleteMapping("autod/{nimi}")
    public List<AutoEntity> kustutaAuto(@PathVariable String nimi) {
        autoRepository.deleteById(nimi);
        return autoRepository.findAll();
    }
    @PutMapping("autod")
    public List<AutoEntity> muudaAuto
            (@RequestParam int index,
             @RequestParam String nimi,
             @RequestParam Integer hind,
             @RequestParam Integer hobuj6ud) {

        AutoEntity auto = new AutoEntity(nimi, hind, hobuj6ud);
        autoRepository.save(auto);
        return autoRepository.findAll();
    }
}
