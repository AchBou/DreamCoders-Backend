package Demo.controllers;

import java.util.List;


//import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.ResponseBody;

import Demo.model.Rubrique;
import Demo.services.RubriqueService;


@RestController
@RequestMapping("/rubrique")
public class RubriqueController {
    @Autowired
    RubriqueService RubService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Rubrique> getAllUsers() {
        return RubService.getAllRubriques();
    }

    @PostMapping(value = "/Create")
    public Rubrique CreateRubrique(@RequestBody Rubrique newRubrique) {
        return  RubService.CreateRubrique(newRubrique);
    }





}
