package ee.tlu.kontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AutoController {
    @Autowired
    AutoRepository autoRepository;

    @GetMapping("autod")
    public List<AutoEntity> getAutod(){
        return autoRepository.findAll();
    }

    @DeleteMapping("autod/{id}")
    public List<AutoEntity> DeleteAuto(@PathVariable Long id){
        autoRepository.deleteById(id);
        return autoRepository.findAll();
    }
    @PostMapping("autod")
    public List<AutoEntity> addAuto(@RequestBody AutoEntity auto){
        autoRepository.save(auto);
        return autoRepository.findAll();
    }
    @GetMapping("autod/{aasta}")
    public  List<AutoEntity>leiaAastaJargi(@PathVariable int aasta){
        return autoRepository.findByAasta(aasta);
    }
    @GetMapping("autod/{minPikkus}/{maxPikkus}")
    public  List<AutoEntity>leiaPikkusteVahel(@PathVariable int minPikkus, int maxPikkus){
        return autoRepository.findByPikkusBetween(minPikkus,maxPikkus);
    }
    @GetMapping("autoSuurimMass")
    public AutoEntity leiaSuurimMass(){
        return autoRepository.findTopByOrderByMassDesc();

}
}
