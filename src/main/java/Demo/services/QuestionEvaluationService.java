package Demo.services;

import Demo.DAO.QuestionEvaluationDAO;
import Demo.DAO.RubriqueEvaluaitonDAO;
import Demo.model.QuestionEvaluation;
import Demo.model.RubriqueEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionEvaluationService {

    @Autowired
    private QuestionEvaluationDAO qevaDAO;
    @Autowired
    private RubriqueEvaluaitonDAO ruevaDAO;

    public List<QuestionEvaluation> addQuestions(List<QuestionEvaluation> questions){
        for (QuestionEvaluation q :
                questions) {
            q.setIdQuestionEvaluation(0);
        }
        return qevaDAO.saveAll(questions);
    }

    public boolean removeQuestions(List<QuestionEvaluation> question){
        if(question.size()>0){
            this.qevaDAO.deleteAll(question);
            return true;
        }
        return false;

    }
}
