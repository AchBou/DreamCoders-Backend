package Demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Demo.model.Evaluation;

@Repository
public interface EvaluationDAO extends JpaRepository<Evaluation, Integer>{

}
