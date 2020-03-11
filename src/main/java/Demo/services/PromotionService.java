package Demo.services;

import Demo.DAO.PromotionDAO;
import Demo.model.Promotion;
import Demo.model.PromotionPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionService {
    @Autowired
    PromotionDAO  promotionDAO;
    //liste de promotions par formation

    public List<PromotionPK> findPromoByFormation(String codeFormation){
        List<PromotionPK> listPromotions = new ArrayList<>();
        List<Promotion> listPromotionByForm = promotionDAO.findByCodeFormation(codeFormation);

        for(Promotion promotion : listPromotionByForm){
            PromotionPK promotionPK= new PromotionPK();
            promotionPK.setCodeFormation(promotion.getId().getCodeFormation());
            promotionPK.setAnneeUniversitaire(promotion.getId().getAnneeUniversitaire());
            listPromotions.add(promotionPK);
        }
       return listPromotions;
   }
}
