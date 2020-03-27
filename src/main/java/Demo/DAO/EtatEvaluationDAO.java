package Demo.DAO;

import Demo.model.views.VEtatEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatEvaluationDAO extends JpaRepository<VEtatEvaluation, String> {
}
