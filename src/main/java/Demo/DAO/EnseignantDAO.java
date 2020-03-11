package Demo.DAO;

import Demo.model.Enseignant;
import Demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantDAO extends JpaRepository<Enseignant, Integer> {
}
