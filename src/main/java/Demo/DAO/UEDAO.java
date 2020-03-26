package Demo.DAO;

import Demo.model.UniteEnseignement;
import Demo.model.ElementConstitutif;
import Demo.model.UniteEnseignementPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UEDAO extends JpaRepository<UniteEnseignement, UniteEnseignementPK> {
    @Query("select UE from UniteEnseignement UE where UE.id.codeFormation = ?1")
    List<UniteEnseignement> findByCodeFormation(String codeFormation);
    
    @Query("Select EC from ElementConstitutif EC where EC.uniteEnseignementt = ?1")
    List<ElementConstitutif> findECByCodeUE(UniteEnseignement UE);
}
