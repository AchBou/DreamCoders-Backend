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
    @Query( "SELECT d "
            + "FROM Question d INNER JOIN d.qualificatif e ORDER BY  e.minimal ASC ")
    public List<Question> ListerparOrdre();

    @Query("SELECT d from Question d,RubriqueQuestion r WHERE" +
            " d.idQuestion = :idQuestion AND " +
            " d.idQuestion = r.questionn.idQuestion")
    public Question FindQstInRub(Integer idQuestion);
    @Query("SELECT d from Question d,QuestionEvaluation qe WHERE" +
            " d.idQuestion = :idQuestion AND " +
            " d.idQuestion = qe.question.idQuestion")
    public Question FindQstInEval(Integer idQuestion);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Question c SET c.enseignant.prenom = :enseignantt ," +
            "c.type = :type,c.intitule=:intitule,c.qualificatif.minimal=:minimal,c.qualificatif.maximal=:maximal " +
            "WHERE c.idQuestion  = :QuestionId")
    Question updateQuestion(@Param("QuestionId") int QuestionId, @Param("enseignantt") String enseignantt,
                            @Param("type") String type ,@Param("intitule") String intitule ,
                            @Param("minimal") String minimal, @Param("maximal") String maximal );
    @Query("SELECT d from Question d WHERE" +
            " d.intitule = :intitule ")
    Question findByIntitule(String intitule);
    @Query("SELECT COUNT(d) from Question d ,RubriqueQuestion r" +
                    " WHERE d.idQuestion = :idQuestion AND " +
                    "d.idQuestion =r.questionn.idQuestion")
    Integer Existorno(Integer idQuestion);

}
