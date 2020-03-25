package Demo.DAO;

import Demo.model.ElementConstitutif;
import Demo.model.ElementConstitutifPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ECDAO extends JpaRepository<ElementConstitutif, ElementConstitutifPK> {

}
