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
    QuestionDAO QuestionDao;

    public List<Question> getQuestions() {

        return this.QuestionDao.findAll();
    }

    public List<Question> getQuestionordre() {

        return this.QuestionDao.ListerparOrdre();
    }
    public Question Create(Question Qst) {
        return this.QuestionDao.save(Qst);
    }

    public Optional<Question> findById(Integer id) {

        return this.QuestionDao.findById(id);
    }

    public Question findQuestifExistinRub(Integer id) {

        return this.QuestionDao.FindQstInRub(id);
    }
    public boolean UpdateQuestion(Question qq) {
        if (this.QuestionDao.findById(qq.getIdQuestion()).isPresent()) {
            this.QuestionDao.save(qq);
            return true ;
        }
        return false;
    }
    public String Existorno(Integer id){
        if(this.QuestionDao.Existorno(id).equals(0)){
            return "no Exist";
        }
        return "Exist";
    }

    public void update(Question qst) {
        QuestionDao.save(qst);
    }

    public void supprimer(Integer id) {

        this.QuestionDao.deleteById(id);
    }

}
