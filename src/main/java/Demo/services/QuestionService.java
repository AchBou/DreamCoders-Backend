package Demo.services;

import java.util.List;

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


}
