package Demo.DAO;

import Demo.model.RubriqueEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubriqueEvaluaitonDAO extends JpaRepository<RubriqueEvaluation, Long> {
}
