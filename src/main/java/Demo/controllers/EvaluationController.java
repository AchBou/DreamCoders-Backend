package Demo.controllers;

import java.util.List;


//import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.ResponseBody;

import Demo.model.Evaluation;
import Demo.services.EvaluationService;


@RestController
@RequestMapping("/eval")
@CrossOrigin(origins="http://localhost:4200", maxAge = 3600)

public class EvaluationController {

    @Autowired
    EvaluationService evaService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @JsonIgnoreProperties(value = { "evaluations" })
    public List<Evaluation> getAllUsers() {
        return evaService.getAllEvals();
    }

    @PostMapping(value = "/update")
    public boolean updateQst(@RequestBody Evaluation evaluation) {

        return  evaService.UpdateEvaluation(evaluation);
    }

    /* @RequestMapping(value = "/adduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public EvaluationService addNewUser(@RequestBody Evaluation eva) {
        return this.evaService.addUser(eva);
    } */
    


}
