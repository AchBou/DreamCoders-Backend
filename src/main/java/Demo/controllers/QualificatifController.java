package Demo.controllers;

import Demo.DAO.QualificatifDAO;
import Demo.model.Qualificatif;
import Demo.model.Question;
import Demo.services.QualificatifService;
import Demo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/qualicatif")
public class QualificatifController {

    @Autowired
    QualificatifService QualificatiSer;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Qualificatif> getAllquallicatif()

    {
        return QualificatiSer.findallqua();
    }



}
