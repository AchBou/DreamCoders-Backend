package Demo.controllers;

import java.util.List;



import Demo.modelPerso.EvaluationPers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import Demo.model.Evaluation;
import Demo.services.EvaluationService;

import javax.ws.rs.core.Response;


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

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Response addNewEval(@RequestBody EvaluationPers eva) {
        try{
            return Response.ok(this.evaService.addEvaluation(eva)).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

    //change etat d'evaluation
    @PostMapping(value = "/publier")
    public Evaluation publierEvaluation(@RequestBody Evaluation eva) {
        return  evaService.publierEvaluation(eva);


    }
    


}
