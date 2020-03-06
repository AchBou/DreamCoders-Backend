package com.example.controllers;

import com.example.model.Question;

import com.example.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
