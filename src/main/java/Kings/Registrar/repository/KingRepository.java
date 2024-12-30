package Kings.Registrar.repository;

import Kings.Registrar.entity.King;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KingRepository extends JpaRepository<King, Long> {
    King findByName(String name);

    @Query("SELECT COUNT(k) FROM King k WHERE k.name = :name")
    int countByName(@Param("name") String name);

}
