package Demo.controllers;

import Demo.model.QuestionEvaluation;
import Demo.services.QuestionEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/questionEvaluation")
@CrossOrigin
public class QuestionEvaluationController {

    @Autowired
    QuestionEvaluationService queService;

    @PostMapping("/addQuestions")
    public Response addQuestions(@RequestBody List<QuestionEvaluation> questions){
        try{
            return Response.ok(this.queService.addQuestions(questions)).build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

    @PutMapping("/deleteQuestions")
    public Response removeQuestions(@RequestBody List<QuestionEvaluation> questions){
        try {
            if(this.queService.removeQuestions(questions)){
                return Response.ok("questions bien suprimee").build();
            }
            return Response.ok("aucune question a suprimer").build();
        }
        catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

}
