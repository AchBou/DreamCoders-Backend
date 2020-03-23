package Demo.controllers;
import Demo.model.Question;
import Demo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService QuestionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        return  new ResponseEntity<>(  QuestionService.getQuestions(), HttpStatus.OK);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestion(@PathVariable  Integer id) {
        try{

            return  new ResponseEntity<>( QuestionService.findById(id).get(), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            return  new ResponseEntity<>(new Question(), HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/qstinrub/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestionInRub(@PathVariable  Integer id)
    {
        return  new ResponseEntity<>( QuestionService.findQuestifExistinRub(id), HttpStatus.OK);

    }

   @RequestMapping(value = "/qstinqualif/{id}", method = RequestMethod.GET)
   public ResponseEntity<String> getQuestionInq(@PathVariable  Integer id)
   {
       return  new ResponseEntity<>( QuestionService.FindQsthasqualif(id), HttpStatus.OK);

   }

    @RequestMapping(value = "/findqstinEva/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> findQstinEva(@PathVariable Integer id)
    {
        return  new ResponseEntity<> ( QuestionService.FindQstinEva(id), HttpStatus.OK);

    }
    @PostMapping("/create")
    ResponseEntity<Question> CreateQuestion(@RequestBody Question newQuestion) {

        return  new ResponseEntity<Question>(QuestionService.Create(newQuestion), HttpStatus.OK);
    }


    @PostMapping(value = "/update")
    public ResponseEntity<Boolean> updateQst(@RequestBody Question nvqst) {
        return  new ResponseEntity<>( QuestionService.UpdateQuestion(nvqst), HttpStatus.OK);

    }



    @DeleteMapping (value = "/supprimer/{id}")

    public ResponseEntity<Boolean> supprimerQuestion(@PathVariable int id) {
        return  new ResponseEntity<>( QuestionService.supprimer(id), HttpStatus.OK);

    }
    }
