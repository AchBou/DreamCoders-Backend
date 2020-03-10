package Demo.controllers;

import Demo.model.Formation;
import Demo.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/form")
public class FormationController {
    @Autowired
    FormationService formationService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Formation> getAllUsers() {
        return formationService.getAllFormations();
    }
}
