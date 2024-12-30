package Kings.Registrar.repository;

import Kings.Registrar.entity.Reincarnation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReincarnationRepository extends JpaRepository<Reincarnation, Integer> {
    List<Reincarnation> findByOriginalPersonId(int originalPersonId);
}
