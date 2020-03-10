package Demo.controllers;

import Demo.DAO.QuestionDAO;
import Demo.model.Question;

import Demo.model.Rubrique;
import Demo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService QuestionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Question> getAllQuestions()
    {
        return QuestionService.getQuestions();
    }


    @GetMapping("/{id}")
    public Optional<Question> getQuestion(@PathVariable  Integer id)
    {
        return QuestionService.findById(id);
    }

    @GetMapping("/qstinrub/{id}")
    public Question getQuestionInRub(@PathVariable  Integer id)
    {
        return QuestionService.findQuestifExistinRub(id);
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public String Existornoo(@PathVariable Integer id) {
        return QuestionService.Existorno(id);
    }

    @PostMapping("/create")
    Question CreateQuestion(@RequestBody Question newQuestion) {
        return QuestionService.Create(newQuestion);
    }



    @PostMapping(value = "/update")
    public boolean updateQst(@RequestBody Question nvqst) {

        return  QuestionService.UpdateQuestion(nvqst);
    }

    @DeleteMapping (value = "/supprimer/{id}")

    public void supprimerQuestion(@PathVariable int id) {

        QuestionService.supprimer(id);
    }
    }
