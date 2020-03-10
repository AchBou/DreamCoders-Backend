package Demo.DAO;

import Demo.model.Promotion;
import Demo.model.PromotionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionDAO extends JpaRepository<Promotion, PromotionPK> {
    @Query("select p from Promotion p where p.id.codeFormation = ?1")
    List<Promotion> findByCodeFormation(String codeFormation);
}
