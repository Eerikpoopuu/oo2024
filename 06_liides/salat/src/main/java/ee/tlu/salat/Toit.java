package ee.tlu.salat;

import ee.tlu.salat.Toidukomponent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Toit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimi;
    @ManyToMany
    List<Toidukomponent> toidukomponendid;


}
