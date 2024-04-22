package ee.tlu.salat;

import lombok.AllArgsConstructor;
import lombok.Getter;

//mis koosneb toiduainest ja temaga seotud kogusest toidu sees
//Klassikomplekt -> Kartul+omadused
@AllArgsConstructor
@Getter
public class Toidukomponent {
    ToiudaineEntity toiduaine;
    int kogus;

}
