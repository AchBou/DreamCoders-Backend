package Demo.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import Demo.DAO.RubriqueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.model.Rubrique;

import javax.ws.rs.NotFoundException;

@Service
public class RubriqueService {
    @Autowired
    RubriqueDAO RubDao;
    public RubriqueService(RubriqueDAO RubDao) {
        this.RubDao = RubDao;
    }

    public List<Rubrique> getAllRubriques() {
        return this.RubDao.findAllByOrderByDesignationAsc();
    }
    public boolean UpdateRubrique(Rubrique Rub) {
            if (this.RubDao.findById(Rub.getIdRubrique()).isPresent()) {

                Rub.setOrdre(BigDecimal.valueOf(0));
                 this.RubDao.save(Rub);
                return true ;
            }
        throw new NotFoundException("Cettre Rubrique n'éxist pas");
        }

    public Optional<Rubrique> FindRubrique(Integer id){
        if (this.RubDao.findById(id).isPresent()) {

            return this.RubDao.findById(id);


        }
        throw new NotFoundException("Cettre Rubrique n'éxist pas");

    }
    public Rubrique CreateRubrique(Rubrique Rub) {
        Rub.setOrdre(BigDecimal.valueOf(0));
           return this.RubDao.save(Rub);
    }
    public boolean Delete(Integer id) {
        if (this.RubDao.findById(id).isPresent()) {
            this.RubDao.deleteById(id);
            return true ;
        }
        throw new NotFoundException("Cette Rubrique n'éxist pas");


    }
    public boolean TestRubLink(Integer id){
        if(this.RubDao.TestRub(id).equals(0)){
            return false;
        }
        return true;
    }



}
