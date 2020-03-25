package Demo.services;

import Demo.DAO.RubriqueEvalDAO;
import Demo.model.RubriqueEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubriqueEvalService {

    @Autowired
    RubriqueEvalDAO rubriqueEvalDAO;

    //lister les rubriques d'une evaluation
    public List<RubriqueEvaluation> findRubriqueByEval(long idEvaluation){
      return rubriqueEvalDAO.findRubriqueByEval(idEvaluation);
    }

    //Supprimer une rubrique
    public boolean deleteRubrique(long idRubrique) {
        if (this.rubriqueEvalDAO.findById(idRubrique).isPresent()) {
            this.rubriqueEvalDAO.deleteById(idRubrique);
            return true ;
        }
        return false;
    }
    //affecter rubrique evaluation

    public RubriqueEvaluation createRubEval(RubriqueEvaluation rq){
        return rubriqueEvalDAO.save(rq);
    }

}
