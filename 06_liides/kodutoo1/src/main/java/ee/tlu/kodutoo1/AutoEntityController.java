package ee.tlu.kodutoo1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AutoEntityController {


    AutoRepository autoRepository;

    public AutoEntityController(AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }

    @GetMapping("autod")
    public List<AutoEntity> saaautod() {
        return autoRepository.findAll();
    }

    @PostMapping("autod")
    public List<AutoEntity> lisaAuto(@RequestBody AutoEntity auto) {
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
