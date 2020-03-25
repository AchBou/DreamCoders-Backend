package Demo.services;

import java.util.ArrayList;
import java.util.List;

import Demo.DAO.EvaluationDAO;
//import Demo.modelPerso.ListeEvalForm;
import Demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Demo.model.Evaluation;

@Service
public class EvaluationService {
	 @Autowired
     EvaluationDAO evaluationDAO;
 
     public List<Evaluation> getAllEvals()
     {
         return this.evaluationDAO.findAll();
     }
 
     public Evaluation addEvaluation(Evaluation eva) {
         return this.evaluationDAO.save(eva);
     }
    //update Evaluation
    public boolean UpdateEvaluation(Evaluation eva) {
        if (this.evaluationDAO.findById(eva.getIdEvaluation()).isPresent()) {
            this.evaluationDAO.save(eva);
            return true ;
        }
        return false;
    }
}
