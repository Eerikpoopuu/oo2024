package ee.tlu.veebipood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToodeController {

    @Autowired
    ToodeRepository toodeRepository;

    @GetMapping("tooted")
    public List<Toode> getTooted(){
        return toodeRepository.findAll();

    }
    @PostMapping("tooted")
    public List<Toode> postToode(@RequestBody Toode toode){
        toodeRepository.save(toode);

        return toodeRepository.findAll();
    }
    @DeleteMapping("tooted/{id}")
    public List<Toode> deleteToode(@PathVariable Long id){
        toodeRepository.deleteById(id);

        return toodeRepository.findAll();
    }
    @GetMapping("toote-hind-vahemik/{min}/{max}")
    public List<Toode> tooteVahemik(@PathVariable double min, @PathVariable double max){
        return toodeRepository.findByHindBetween(min,max);
    }
    @GetMapping("max")
    public Toode tootemax(){
        return toodeRepository.findFirstByHindNotNullAllIgnoreCaseOrderByHindDesc();
    }



}
