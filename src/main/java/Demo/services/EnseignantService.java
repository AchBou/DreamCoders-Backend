package Demo.services;

import Demo.DAO.EnseignantDAO;
import Demo.model.Enseignant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantService {

    private final EnseignantDAO enseignantDAO;
    public EnseignantService(EnseignantDAO enseignantDAO) {
        this.enseignantDAO = enseignantDAO;
    }

    public List<Enseignant> findallEns() {

        return this.enseignantDAO.findAll();
    }
    public Optional<Enseignant> getbyid(Integer id){
        return this.enseignantDAO.findById(id);
    }
}
