package Demo.services;

import Demo.DAO.QualificatifDAO;
import Demo.model.Qualificatif;
import org.springframework.stereotype.Service;
import Exception.*;

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

    public  Optional<Qualificatif> getbyid(Integer id) throws SprintException {
        return this.qualificatifDAO.findById(id);
    }
    public Qualificatif Create(Qualificatif Qual) throws SprintException
    {
        return this.qualificatifDAO.save(Qual);
    }

    public boolean FindQualifinQsts(Integer id){
        if(this.qualificatifDAO.FindquaInQsts(id) == null){
            return false;
        }
        return true;
    }


    public boolean UpdateQual(Qualificatif qua) {
        if (this.qualificatifDAO.findById(qua.getIdQualificatif()).isPresent()) {
            this.qualificatifDAO.save(qua);
            return true ;
        }
        return false;
    }

    public Boolean supprimerqua(Integer id) {
        this.qualificatifDAO.deleteById(id);
        return true;
    }


}
