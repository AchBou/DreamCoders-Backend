package Demo.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Demo.DAO.QuestionDAO;
import Demo.model.Question;

@Service
public class QuestionService {

    @Autowired
    private final QuestionDAO questionDao;
    public QuestionService(QuestionDAO questionDao) {
        this.questionDao = questionDao;
    }
    public List<Question> getQuestions() {

        return this.questionDao.findAll();
    }

    public List<Question> getQuestionordre() {

        return this.questionDao.ListerparOrdre();
    }
    public Question Create(Question Qst) {
        return this.questionDao.save(Qst);
    }

    public Optional<Question> findById(Integer id) {

        return this.questionDao.findById(id);
    }

    public boolean findQuestifExistinRub(Integer id) {
        if(this.questionDao.FindQstInRub(id) == null){
            return false;
        }
        return true;

    }
    public boolean UpdateQuestion(Question qq) {
        if (this.questionDao.findById(qq.getIdQuestion()).isPresent()) {
            this.questionDao.save(qq);
            return true ;
        }
        return false;
    }
    public String Existorno(Integer id){
        if(this.questionDao.Existorno(id).equals(0)){
            return "no Exist";
        }
        return "Exist";
    }
    public boolean FindQstinEva(Integer id){
        if(this.questionDao.FindQstInEval(id) == null){
            return false;
        }
        return true;
    }
    public boolean FindQsthasqualif(Integer id){
        if(this.questionDao.FindQstHasQualif(id) == null){
            return false;
        }
        return true;
    }


    public void update(Question qst) {
        questionDao.save(qst);
    }

    public Boolean supprimer(Integer id) {

        this.questionDao.deleteById(id);
        return true;
    }


}
