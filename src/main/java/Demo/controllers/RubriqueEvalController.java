package Demo.controllers;

import Demo.DAO.EvaluationDAO;
import Demo.DAO.RubriqueDAO;
import Demo.model.Evaluation;
import Demo.model.Rubrique;
import Demo.model.RubriqueEvaluation;
import Demo.services.EvaluationService;
import Demo.services.RubriqueEvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rubriqueEval")
public class RubriqueEvalController {

    @Autowired
    RubriqueEvalService rubriqueEvalService;

    @Autowired
    EvaluationService evaluationService;

    @Autowired

    EvaluationDAO evaluationDAO;
    @Autowired
    RubriqueDAO rubriqueDAO;




    //listee ***********
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Rubrique> getRubriqueByEval(@PathVariable long id) {
        List<Rubrique> rubriques = new ArrayList<>();
         rubriqueEvalService.findRubriqueByEval(id).forEach(rubriqueEvaluation -> {
            rubriques.add(rubriqueEvaluation.getRubrique());
        });
        return rubriques;

    }
    @GetMapping(value = "/create/{idEvaluation}/{idRubrique}")
    public RubriqueEvaluation createRubriqueEval(@PathVariable long idEvaluation,@PathVariable int idRubrique) {
        Integer iInteger = new Integer(idRubrique);

        RubriqueEvaluation rubriqueEvaluation = new RubriqueEvaluation();
        rubriqueEvaluation.setEvaluation(evaluationDAO.getOne(idEvaluation));
        rubriqueEvaluation.setRubrique(rubriqueDAO.getOne(iInteger));
        rubriqueEvaluation.setOrdre(BigDecimal.valueOf(0));

        return rubriqueEvalService.createRubEval(rubriqueEvaluation);


    }
    @DeleteMapping (value = "/supprimer/{idRubriqueEvaluation}")

    public boolean supprimerRubriqueEval(@PathVariable long idRubriqueEvaluation) {
        return rubriqueEvalService.deleteRubrique(idRubriqueEvaluation);
    }
}
