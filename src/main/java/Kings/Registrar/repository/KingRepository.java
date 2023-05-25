package Kings.Registrar.repository;

import Kings.Registrar.entity.King;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KingRepository extends JpaRepository<King, Long> {
    King findByName(String name);
    int countByName(String name);
}
