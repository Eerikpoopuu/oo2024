package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToidukomponentController {
    @Autowired
    ToidukomponentRepository toidukomponentRepository;

    @GetMapping("toidukomponendid")
    public List<Toidukomponent> getToidukomponents() {

        return toidukomponentRepository.findAll();
    }
    @DeleteMapping("toidukomponendid/{id}")
    public List<Toidukomponent> deleteToidukomponent(@PathVariable Long id){
        toidukomponentRepository.deleteById(id);
        return toidukomponentRepository.findAll();
    }
    @PostMapping("toidukomponendid")
    public List<Toidukomponent> addToidukomponent(@RequestBody Toidukomponent toidukomponent){
        toidukomponentRepository.save(toidukomponent);
        return  toidukomponentRepository.findAll();
    }


}
