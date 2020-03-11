package Demo.services;

import Demo.DAO.FormationDAO;
import Demo.model.Formation;
import Demo.modelPerso.FormationPers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormationService {

    @Autowired
    FormationDAO formationDAO;
    //Liste de toute les formations
    public List<FormationPers> getAllFormations(){
        List<FormationPers> listFormationsPers = new ArrayList<>();
        List<Formation> listFormations = formationDAO.findAll();
        for(Formation formation : listFormations){
            FormationPers formationPers = new FormationPers();
            formationPers.setNomFormation(formation.getNomFormation());
            formationPers.setCodeFormation(formation.getCodeFormation());
            listFormationsPers.add(formationPers);
        }
        return listFormationsPers;}
}
