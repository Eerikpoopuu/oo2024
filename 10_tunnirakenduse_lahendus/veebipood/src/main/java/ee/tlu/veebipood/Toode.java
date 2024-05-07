package ee.tlu.veebipood;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Toode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimi;
    private Integer hind;
    private Boolean aktiivne;
    @ManyToOne
    private Kategooria kategooria;

//    {
//        "nimi": "cola",
//        "hind": 2,
//        "aktiivne": true,
//        "kategooria": {"id": 2}
//    }
}
