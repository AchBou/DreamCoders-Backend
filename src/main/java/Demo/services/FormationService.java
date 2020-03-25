package Demo.services;

import Demo.DAO.FormationDAO;
import Demo.model.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {

    @Autowired
    FormationDAO formationDAO;
    //Liste de toute les formations
    public List<Formation> getAllFormations(){
        List<Formation> listFormations = formationDAO.findAll();
        return listFormations;}
}
