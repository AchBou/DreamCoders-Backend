package Demo.services;

import java.util.List;
import java.util.Optional;

import Demo.DAO.QuestionDAO;
import Demo.DAO.RubriqueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.model.Rubrique;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

@Service
public class RubriqueService {
    @Autowired
    RubriqueDAO userDao;
    private final RubriqueDAO RubDao;
    public RubriqueService(RubriqueDAO RubDao) {
        this.RubDao = RubDao;
    }

    public List<Rubrique> getAllRubriques() {
        return this.userDao.Order();
    }
    public boolean UpdateRubrique(Rubrique Rub) {
            if (this.userDao.findById(Rub.getIdRubrique()).isPresent()) {
                 this.userDao.save(Rub);
                return true ;
            }
        throw new NotFoundException("Cettre Rubrique n'exist pas");
        }

    public Optional<Rubrique> FindRubrique(Integer id){
        if (this.userDao.findById(id).isPresent()) {

            return this.userDao.findById(id);


        }
        throw new NotFoundException("Cettre Rubrique n'exist pas");

    }
    public Rubrique CreateRubrique(Rubrique Rub) {

           return this.userDao.save(Rub);
    }
    public boolean Delete(Integer id) {
        if (this.userDao.findById(id).isPresent()) {
            this.userDao.deleteById(id);
            return true ;
        }
        throw new NotFoundException("Cettre Rubrique n'exist pas");


    }
    public boolean TestRubLink(Integer id){
        if(this.userDao.TestRub(id).equals(0)){
            return false;

        }
        throw new BadRequestException("Cette Rubrique est deja utilisée");


    }



}
