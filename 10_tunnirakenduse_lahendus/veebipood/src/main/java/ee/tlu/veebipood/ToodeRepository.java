package ee.tlu.veebipood;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToodeRepository extends JpaRepository<Toode, Long> {


    List<Toode> findByHindBetween(Double hindStart, Double hindEnd);

    Toode findFirstByHindNotNullAllIgnoreCaseOrderByHindDesc();

    List<Toode> findByNimiStartsWith(String nimi);

    List<Toode> findByNimiContains(String nimi);

}
