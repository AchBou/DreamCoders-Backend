package Demo.DAO;

import Demo.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EvaluationDAO extends JpaRepository<Evaluation, Long>{

}
