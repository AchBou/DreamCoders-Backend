package Demo.services;

import java.util.List;

import Demo.DAO.EvaluationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import Demo.DAO.EvaluationDAO;
>>>>>>> 6cd200e2e1d3269158cdd8e7b0a6ca4bdaa27b0f
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
