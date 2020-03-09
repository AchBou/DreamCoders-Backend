package Demo.services;

import java.util.List;
import java.util.Optional;

import Demo.DAO.RubriqueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.model.Rubrique;

@Service
public class RubriqueService {
    @Autowired
    RubriqueDAO userDao;

    public List<Rubrique> getAllRubriques() {
        return this.userDao.Order();
    }
    public boolean UpdateRubrique(Rubrique Rub) {
            if (this.userDao.findById(Rub.getIdRubrique()).isPresent()) {
                 this.userDao.save(Rub);
                return true ;
            }
            return false;
        }

    public Optional<Rubrique> FindRubrique(Integer id){return this.userDao.findById(id);}
    public Rubrique CreateRubrique(Rubrique Rub) {

           return this.userDao.save(Rub);
    }
    public boolean Delete(Integer id) {
        if (this.userDao.findById(id).isPresent()) {
            this.userDao.deleteById(id);
            return true ;
        }
        return false;
    }
    public boolean TestRubLink(Integer id){
        if(this.userDao.TestRub(id).equals(0)){
            return false;
        }
        return true;
    }



}
