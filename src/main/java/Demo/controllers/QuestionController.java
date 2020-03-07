package Demo.controllers;

import Demo.model.Question;

import Demo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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

    @PostMapping("/Create")
    Question CreateQuestion(@RequestBody Question newQuestion) {
        return QuestionService.Create(newQuestion);

    }
}
