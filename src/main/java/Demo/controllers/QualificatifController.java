package Demo.controllers;


import Demo.model.Qualificatif;
import Demo.services.QualificatifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
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
