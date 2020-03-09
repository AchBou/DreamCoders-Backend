package Demo.controllers;

import Demo.DAO.QuestionDAO;
import Demo.model.Question;

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


@RestController
@RequestMapping("/Question")
public class QuestionController {
    @Autowired
    QuestionService QuestionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Question> getAllQuestions()
    {
        return QuestionService.getQuestions();
    }

    @GetMapping(value = "/FindifinRub/{id}")
    public List<Question> getFindifinRub(@PathVariable Integer id)

    {
        return QuestionService.findQstifinRub(id);
    }

    @GetMapping("/UneQuestion/{id}")
    public Optional<Question> getQuestion(@PathVariable  Integer id)
    {
        return QuestionService.findById(id);
    }

    @RequestMapping("/AllbyOrdreMinimalQual")
    public List<Question> getAllQuestionsbytype()
    {
        return QuestionService.getQuestionordre();
    }
    @PostMapping("/Create")
    Question CreateQuestion(@RequestBody Question newQuestion) {
        return QuestionService.Create(newQuestion);
    }


    @PutMapping("/QuestionModify/{id}")
    Question replaceQuestion(@RequestBody Question NvQ, @PathVariable Integer id) {

        return QuestionService.findById(id)
                .map(Qst -> {
                    Qst.setEnseignantt(NvQ.getEnseignantt());
                    Qst.setType(NvQ.getType());
                    Qst.setIntitule(NvQ.getIntitule());
                    Qst.setQualificatiff(NvQ.getQualificatiff());
                    return QuestionService.Create(Qst);
                })
                .orElseGet(() -> {
                    NvQ.setIdQuestion(id);
                    return QuestionService.Create(NvQ);
                });
    }

    @DeleteMapping (value = "/Supprimer/{id}")
    public boolean SupprimerQuestion(@PathVariable int id) {

       return QuestionService.Supprimer(id);
    }
    }
