package Demo.controllers;

import java.util.List;



import Demo.modelPerso.EvaluationPers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import Demo.model.Evaluation;
import Demo.services.EvaluationService;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;


@RestController
@RequestMapping("/eval")
@CrossOrigin(origins="http://localhost:4200")

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
    @ResponseBody
    public Response addEval(@RequestBody EvaluationPers eva) {
        try {
            Evaluation ev = this.evaService.addUser(eva);
            return Response.ok(ev).build();
        }
        catch (NotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        catch (BadRequestException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
    


}
