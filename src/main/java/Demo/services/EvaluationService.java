package Demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.DAO.EvaluationDAO;
import Demo.model.Evaluation;

@Service
public class EvaluationService {
	 @Autowired
     EvaluationDAO userDao;
 
     public List<Evaluation> getAllEvals() {
         return this.userDao.findAll();
     }
 
     public Evaluation addUser(Evaluation eva) {
         return this.userDao.save(eva);
     }

}
