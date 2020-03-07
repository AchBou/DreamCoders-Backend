package Demo.services;

import java.util.List;

import Demo.DAO.RubriqueDAO;
import Demo.model.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.model.Rubrique;

@Service
public class RubriqueService {
    @Autowired
    RubriqueDAO userDao;

    public List<Rubrique> getAllRubriques() {
        return this.userDao.findAll();
    }
    public Rubrique CreateRubrique(Rubrique Rub) {
        return this.userDao.save(Rub);
    }




}
