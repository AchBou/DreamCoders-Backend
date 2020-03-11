package Demo.services;

import Demo.DAO.UEDAO;
import Demo.model.ElementConstitutif;
import Demo.model.ElementConstitutifPK;
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

    public List<UniteEnseignementPK> findPromoByFormation(String codeFormation){
        List<UniteEnseignementPK> listUnitesEnseignement = new ArrayList<>();
        List<UniteEnseignement> listUnitesEnseignementByForm = ueDAO.findByCodeFormation(codeFormation);

        for(UniteEnseignement uniteEnseignement : listUnitesEnseignementByForm){
        	UniteEnseignementPK uniteEnseignementPK= new UniteEnseignementPK();
        	uniteEnseignementPK.setCodeFormation(uniteEnseignement.getId().getCodeFormation());
        	uniteEnseignementPK.setCodeUe(uniteEnseignement.getId().getCodeUe());
            listUnitesEnseignement.add(uniteEnseignementPK);
        }
       return listUnitesEnseignement;
    }
    
    public List<ElementConstitutifPK> findECByUE(String codeUE){
        List<ElementConstitutifPK> listElementsConstitutifs = new ArrayList<>();
        List<ElementConstitutif> listElementsConstitutifsByUE = ueDAO.findECByCodeUE(codeUE);

        for(ElementConstitutif elementConstitutif : listElementsConstitutifsByUE){
        	ElementConstitutifPK elementConstitutifPK= new ElementConstitutifPK();
        	elementConstitutifPK.setCodeFormation(elementConstitutif.getId().getCodeFormation());
        	elementConstitutifPK.setCodeUe(elementConstitutif.getId().getCodeUe());
        	elementConstitutifPK.setCodeEc(elementConstitutif.getId().getCodeEc());
            listElementsConstitutifs.add(elementConstitutifPK);
        }
       return listElementsConstitutifs;
    }
    
    public List<UniteEnseignementPK> findAllUEs() {
    	List<UniteEnseignementPK> listUnitesEnseignement = new ArrayList<>();
    	return listUnitesEnseignement;
    }
}
