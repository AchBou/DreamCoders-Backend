package Demo.controllers;

import Demo.model.Enseignant;
import Demo.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/enseignant")
public class EnseignantController {

    @Autowired
    EnseignantService EnseignantSer;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Enseignant> getAllEnseignant()

    {
        return EnseignantSer.findallEns();
    }

}
