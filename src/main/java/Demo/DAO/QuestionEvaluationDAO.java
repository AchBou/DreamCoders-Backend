package Demo.DAO;

import Demo.model.QuestionEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionEvaluationDAO extends JpaRepository<QuestionEvaluation, Long> {
}
