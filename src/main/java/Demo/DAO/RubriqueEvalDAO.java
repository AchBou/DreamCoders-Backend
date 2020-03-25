package Demo.DAO;

import Demo.model.RubriqueEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RubriqueEvalDAO extends JpaRepository<RubriqueEvaluation, Long> {
    //liste rubrique par evaluation
    @Query(value = "select r from RubriqueEvaluation r where r.evaluationn.idEvaluation = ?1")
    public List<RubriqueEvaluation> findRubriqueByEval(long idEvaluation);


}
