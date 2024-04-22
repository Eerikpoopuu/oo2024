package ee.tlu.salat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "toiduaine")//vabatahtlik -nimevahetus
@Entity// andmebaasipanekuks
@NoArgsConstructor
public class ToiudaineEntity {
    @Id// kustutamiseks,võtmiseks,muutmiseks
    String nimetus;
    int valk;
    int rasv;
    int sysivesik;

//    public ToiudaineEntity(String nimetus, int valk, int rasv, int sysivesik) {
//        this.nimetus = nimetus;
//        this.valk = valk;
//        this.rasv = rasv;
//        this.sysivesik = sysivesik;
//    }
}
