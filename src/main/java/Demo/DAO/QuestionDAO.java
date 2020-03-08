package Demo.DAO;
import Demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface QuestionDAO  extends JpaRepository<Question , Integer> {
    @Query("SELECT d "
            + "FROM Question d INNER JOIN d.qualificatiff e ORDER BY e.minimal ASC ")
    public List<Question> ListerparOrdre();


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Question c SET c.enseignantt.prenom = :enseignantt ," +
            "c.type = :type,c.intitule=:intitule,c.qualificatiff.minimal=:minimal,c.qualificatiff.maximal=:maximal " +
            "WHERE c.idQuestion  = :QuestionId")
    Question updateQuestion(@Param("QuestionId") int QuestionId, @Param("enseignantt") String enseignantt,
                            @Param("type") String type ,@Param("intitule") String intitule ,
                            @Param("minimal") String minimal, @Param("maximal") String maximal );
}
