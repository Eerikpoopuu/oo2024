package ee.tlu.kontrolltoo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<AutoEntity,Long> {
    List<AutoEntity> findByAasta(int aasta);
    List<AutoEntity> findByPikkusBetween(int pikkusStart, int pikkusEnd);

    AutoEntity findTopByOrderByMassDesc();


}
