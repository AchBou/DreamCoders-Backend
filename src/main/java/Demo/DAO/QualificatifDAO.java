package Demo.DAO;

import Demo.model.Qualificatif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificatifDAO extends JpaRepository<Qualificatif, Integer> {
}
