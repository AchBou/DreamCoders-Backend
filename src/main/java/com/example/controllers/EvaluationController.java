package com.example.controllers;

import java.util.List;

//import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Evaluation;
import com.example.services.EvaluationService;


@RestController
@RequestMapping("/eval")
public class EvaluationController {
    @Autowired
    EvaluationService evaService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Evaluation> getAllUsers() {
        return evaService.getAllEvals();
    }

    /* @RequestMapping(value = "/adduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public EvaluationService addNewUser(@RequestBody Evaluation eva) {
        return this.evaService.addUser(eva);
    } */
    


}