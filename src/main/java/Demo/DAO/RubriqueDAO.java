package Demo.DAO;

import Demo.model.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubriqueDAO extends JpaRepository<Rubrique, Integer>{
   /* @Query("SELECT d "
            + "FROM Rubrique d ORDER BY d.designation ASC ")
    public List<Rubrique> Order();*/

    @Query(
            value = "SELECT COUNT(*) FROM (SELECT RUBRIQUE.ID_RUBRIQUE FROM RUBRIQUE ,RUBRIQUE_QUESTION" +
                    " WHERE RUBRIQUE.ID_RUBRIQUE = ?1 AND  RUBRIQUE.ID_RUBRIQUE=RUBRIQUE_QUESTION.ID_RUBRIQUE UNION SELECT RUBRIQUE.ID_RUBRIQUE " +
                    "FROM RUBRIQUE ,RUBRIQUE_EVALUATION WHERE RUBRIQUE.ID_RUBRIQUE = ?1 AND  RUBRIQUE.ID_RUBRIQUE=RUBRIQUE_EVALUATION.ID_RUBRIQUE)",
            nativeQuery = true)

    Integer TestRub(Integer idQuestion);

	public List<Rubrique> findAllByOrderByDesignationAsc();
}
