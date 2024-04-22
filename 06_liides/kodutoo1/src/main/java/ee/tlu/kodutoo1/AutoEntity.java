package ee.tlu.kodutoo1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name= "auto")
@Entity// andmebaasipanekuks
@NoArgsConstructor
public class AutoEntity {
    @Id
    String nimi;
    Integer hind;
    Integer hobuj6ud;
}
//    public AutoEntity(String nimi, Integer hind, Integer hobuj6ud) {
//        this.nimi = nimi;
//        this.hind = hind;
//        this.hobuj6ud = hobuj6ud;
//    }
//}
