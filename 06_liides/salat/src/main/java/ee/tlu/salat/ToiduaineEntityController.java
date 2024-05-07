package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ToiduaineEntityController {


    //List<ToiudaineEntity> toiduained = new ArrayList<>();

    ToiduaineRepository toiduaineRepository;

    public ToiduaineEntityController(ToiduaineRepository toiduaineRepository){
        this.toiduaineRepository = toiduaineRepository;
    }



    @GetMapping("toiduained")
    public List<ToiudaineEntity> saaToiduained() {
        return toiduaineRepository.findAll();
    }

    //järjekord tähtis,vüin sassi ajada, ei saa ühtegi vahelejäta
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiudaineEntity> lisaToiduaine(
            @PathVariable String nimi,
            @PathVariable int valk,
            @PathVariable int rasv,
            @PathVariable int sysivesik
    ) {
        if(valk+rasv+sysivesik> 100){
            return toiduaineRepository.findAll();
        }
        ToiudaineEntity toiduaine =new ToiudaineEntity(nimi,valk,rasv,sysivesik);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    @PostMapping("toiduained")
    public List<ToiudaineEntity> lisaToiduaine(@RequestBody ToiudaineEntity toiduaineEntity)
    {
        if(toiduaineEntity.getValk()+toiduaineEntity.getRasv()+toiduaineEntity.getSysivesik()> 100){
            return toiduaineRepository.findAll();
        }
        //ToiudaineEntity toiduaine =new ToiudaineEntity(nimi,valk,rasv,sysivesik);
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }

    @DeleteMapping("toiduained/{nimi}")
    public List<ToiudaineEntity> kustutaToiduaine(@PathVariable String nimi) {
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
    }

    //siin saab vehelejäta
    @PutMapping("toiduained")
    public List<ToiudaineEntity> muudaToiduaine(
            @RequestParam int index,
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
    ) {
        ToiudaineEntity toiduaine =new ToiudaineEntity(nimi,valk,rasv,sysivesik);
        //toiduained.set(index,toiduaine);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    @GetMapping("toiduained/{nimi}")
    public ToiudaineEntity saaYksToiduaine(@PathVariable String nimi) {
        return toiduaineRepository.findById(nimi).get();
    }
    @GetMapping("toiduainete-koguarv")
    public int toiduaineteKoguarv(){
        return  toiduaineRepository.findAll().size();
    }
}


