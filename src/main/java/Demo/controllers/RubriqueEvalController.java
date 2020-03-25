package Demo.controllers;

import Demo.model.RubriqueEvaluation;
import Demo.services.RubriqueEvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rubriqueEval")
public class RubriqueEvalController {

    @Autowired
    RubriqueEvalService rubriqueEvalService;

    //listee ***********
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<RubriqueEvaluation> getRubriqueByEval(@PathVariable long id) {
        return rubriqueEvalService.findRubriqueByEval(id);
    }
    @PostMapping(value = "/Create")
    public RubriqueEvaluation createRubriqueEval(@RequestBody RubriqueEvaluation rq) {
        return  rubriqueEvalService.createRubEval(rq);
    }
    @DeleteMapping (value = "/supprimer/{id}")

    public void supprimerRubriqueEval(@PathVariable int id) {

        rubriqueEvalService.deleteRubrique(id);
    }
}
