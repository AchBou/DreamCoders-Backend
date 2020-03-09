package Demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import Demo.DAO.QuestionDAO;
import Demo.model.Question;
import org.springframework.web.bind.annotation.PathVariable;

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
    public List<Question> findQstifinRub(Integer id){
        return  this.QuestionDao.FindQstInRub(id);
    }
    public void update(Question qst) {
        QuestionDao.save(qst);
    }

    public boolean Supprimer(Integer id) {
if(this.QuestionDao.findById(id).isPresent()){
        this.QuestionDao.deleteById(id);
return true;
    }
    return false;
}

}
