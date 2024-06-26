package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToitController {

    @Autowired
    ToitRepository toitRepository;


    @GetMapping("toit")
    public List<Toit> getToidud(){
        return toitRepository.findAll();
    }

    @DeleteMapping("toit/{id}")
    public List<Toit> DeleteToit(@PathVariable Long id){
        toitRepository.deleteById(id);
        return toitRepository.findAll();
    }
    @PutMapping("toit")
    public List<Toit> addToit(@RequestBody Toit toit){
        toitRepository.save(toit);
        return toitRepository.findAll();
    }

}
