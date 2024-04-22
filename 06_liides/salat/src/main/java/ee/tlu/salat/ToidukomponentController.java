package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToidukomponentController {
    List<Toidukomponent> toidukomponentid = new ArrayList<>();

    @PostMapping("toidukomponent")
    public List<Toidukomponent> lisaToidukomponent(@RequestBody Toidukomponent komponent)
    {
     toidukomponentid.add(komponent);

        return toidukomponentid;
    }
    @PutMapping("toidukomponent/{index}")
    public List<Toidukomponent> lisaToidukomponent(@PathVariable int index, @RequestBody Toidukomponent komponent)
    {
        toidukomponentid.set(index,komponent);

        return toidukomponentid;
    }
}
