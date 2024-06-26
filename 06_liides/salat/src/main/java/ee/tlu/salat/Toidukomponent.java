package ee.tlu.salat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//mis koosneb toiduainest ja temaga seotud kogusest toidu sees
//Klassikomplekt -> Kartul+omadused
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Toidukomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    ToiudaineEntity toiduaine;
    int kogus;

}
