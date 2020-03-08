package Demo.controllers;

import java.util.List;
import java.util.Optional;


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
    public List<Rubrique> getAllRubriques() {
        return RubService.getAllRubriques();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Rubrique getRubrique(@PathVariable Integer id) {
        return RubService.FindRubrique(id).get();
    }
    @PostMapping(value = "/Create")
    public Rubrique CreateRubrique(@RequestBody Rubrique newRubrique) {
        return  RubService.CreateRubrique(newRubrique);
    }
    @PostMapping(value = "/Update")
    public Rubrique UpdateRubrique(@RequestBody Rubrique newRubrique) {
        return  RubService.UpdateRubrique(newRubrique);
    }
    @DeleteMapping (value = "/Supprimer/{id}")
    public void RubriqueQuestion(@PathVariable int id) {

        RubService.Delete(id);
    }




}
