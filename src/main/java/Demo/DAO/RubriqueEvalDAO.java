package Demo.DAO;

import Demo.model.RubriqueEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;
import java.util.List;

public interface RubriqueEvalDAO extends JpaRepository<RubriqueEvaluation, Long> {
    //liste rubrique par evaluation*******
    @Query(value = "select r from RubriqueEvaluation r where r.evaluation.idEvaluation = ?1 order by r.rubrique.designation asc")
    public List<RubriqueEvaluation> findRubriqueByEval(long idEvaluation);

    @Transactional
    @Modifying
    @Query(value = "delete from RubriqueEvaluation r where r.evaluation.idEvaluation = ?1 and r.rubrique.idRubrique = ?2")
    public void  deleterubriqueeval(long idEvaluation,  Integer idRubrique);

}
