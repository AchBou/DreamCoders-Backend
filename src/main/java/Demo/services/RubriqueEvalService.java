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
    @Autowired
    QuestionEvaluationService questionEvaluationService;

    //lister les rubriques d'une evaluation****
    public List<RubriqueEvaluation> findRubriqueByEval(long idEvaluation){
      return rubriqueEvalDAO.findRubriqueByEval(idEvaluation);
    }

    //Supprimer une rubrique*****
    public boolean deleteRubrique(long idRubriqueEvaluation) {
        RubriqueEvaluation re = rubriqueEvalDAO.getOne(idRubriqueEvaluation);
        this.questionEvaluationService.removeQuestions(re.getQuestionEvaluations());
        rubriqueEvalDAO.delete(re);
        return true;
    }
    //affecter rubrique evaluation***

    public RubriqueEvaluation createRubEval(RubriqueEvaluation rq){
        return rubriqueEvalDAO.save(rq);
    }

}
