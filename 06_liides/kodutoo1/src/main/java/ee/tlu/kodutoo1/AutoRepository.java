package ee.tlu.kodutoo1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<AutoEntity,String> {

    List<AutoEntity> findByHindGreaterThan(Integer hind);

    List<AutoEntity> findByHobuj6udBetween(Integer hobuj6udStart, Integer hobuj6udEnd);
}
