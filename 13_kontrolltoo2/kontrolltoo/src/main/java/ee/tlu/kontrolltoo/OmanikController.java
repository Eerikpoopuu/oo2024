//package ee.tlu.kontrolltoo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//public class OmanikController {
//    @Autowired
//    OmanikRepository omanikRepository;
//
//    @GetMapping("omanik/{Nimi}")
//    public List<Omanik> getOmanik(@PathVariable String Nimi){return (List<Omanik>) omanikRepository.findTopByOmanikNimiOrderByPikkusDesc(Nimi);
//    }
//    @PostMapping("omanik")
//    public List<Omanik> AddOmanik(@RequestBody Omanik omanik){
//        omanikRepository.save(omanik);
//        return omanikRepository.findAll();
//    }
//}
