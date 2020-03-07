package Demo.DAO;

import Demo.model.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubriqueDAO extends JpaRepository<Rubrique, Integer>{

}
