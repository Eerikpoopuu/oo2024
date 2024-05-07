package ee.tlu.kodutoo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OmanikEntityController {

    @Autowired OmanikRepository omanikRepository;
    @Autowired
    private AutoRepository autoRepository;

    @GetMapping("autoomanik")
    public List<OmanikEntity> getOmanik(){
        return omanikRepository.findAll();
    }
    @DeleteMapping("autoomanik/{id}")
    public List<OmanikEntity> deleteOmanik(@PathVariable Long id){
        omanikRepository.deleteById(id);
        return omanikRepository.findAll();
    }
    @PostMapping("autoomanik")
    public List<OmanikEntity> addOmanik(@RequestBody OmanikEntity omanikEntity){
        omanikRepository.save(omanikEntity);
        return  omanikRepository.findAll();
    }
}
