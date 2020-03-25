package Demo.DAO;

import Demo.model.Qualificatif;
import Demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificatifDAO extends JpaRepository<Qualificatif, Integer> {
    @Query("SELECT Q from Qualificatif  Q, Question  d WHERE " +
            "Q.idQualificatif = :idQualificatif AND  Q.idQualificatif  = d.qualificatif.idQualificatif ")
    public Qualificatif FindquaInQsts(Integer idQualificatif);
}
