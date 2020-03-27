package Demo.services;

import Demo.DAO.UEDAO;
import Demo.model.ElementConstitutif;
import Demo.model.UniteEnseignement;
import Demo.model.UniteEnseignementPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UEService {
    @Autowired
    UEDAO  ueDAO;
    // liste d'unités d'enseignement par formation

    public List<UniteEnseignement> findUEByFormation(String codeFormation){
        List<UniteEnseignement> listUnitesEnseignementByForm = ueDAO.findByCodeFormation(codeFormation);

       return listUnitesEnseignementByForm;
    }
    
    public List<ElementConstitutif> findECByUE(String codeUE, String codeFormation){
        UniteEnseignement ue = ueDAO.getOne(new UniteEnseignementPK(codeFormation,codeUE));
        List<ElementConstitutif> listElementsConstitutifsByUE = ueDAO.findECByCodeUE(ue);

       return listElementsConstitutifsByUE;
    }
    
    public List<UniteEnseignement> findAllUEs() {
    	List<UniteEnseignement> listUnitesEnseignement = new ArrayList<>();
    	return listUnitesEnseignement;
    }
}
