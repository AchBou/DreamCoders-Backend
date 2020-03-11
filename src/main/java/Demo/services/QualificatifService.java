package Demo.services;

import Demo.DAO.QualificatifDAO;
import Demo.DAO.QuestionDAO;
import Demo.model.Qualificatif;
import Demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificatifService {



     private  final  QualificatifDAO qualificatifDAO;

    public QualificatifService(QualificatifDAO qualificatifDao) {
        this.qualificatifDAO = qualificatifDao;
    }
    public List<Qualificatif> findallqua() {

        return this.qualificatifDAO.findAll();
    }
public  Optional<Qualificatif> getbyid(Integer id){
        return this.qualificatifDAO.findById(id);
}


}
