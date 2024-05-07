package ee.tlu.veebipood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KategooriaController {

    @Autowired
    KategooriaRepository kategooriaRepository;
    @GetMapping("kategooriad")
    public List<Kategooria> getKategooriad(){
        return kategooriaRepository.findAll();

    }
    @PostMapping("kategooriad")
    public List<Kategooria> postKategooria(@RequestBody Kategooria kategooria){
        kategooriaRepository.save(kategooria);

        return kategooriaRepository.findAll();
    }
    @DeleteMapping("kategooriad/{id}")
    public List<Kategooria> deleteKategooria(@PathVariable Long id){
        kategooriaRepository.deleteById(id);

        return kategooriaRepository.findAll();
    }
}
