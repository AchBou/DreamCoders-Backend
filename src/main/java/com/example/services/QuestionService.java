package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.DAO.QuestionDAO;
import com.example.model.Question;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO QuestionDao;
    public List<Question> getQuestions() {
        return this.QuestionDao.findAll();
    }


}
