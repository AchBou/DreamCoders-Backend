package Demo.controllers;

import Demo.model.Qualificatif;
import Demo.services.QualificatifService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Exception.*;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/qualicatif")
public class QualificatifController {
    private static final Logger logger = LoggerFactory.getLogger(QualificatifController.class);
    @Autowired
    QualificatifService QualificatiSer;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Collection<Qualificatif>> getAllQualif() {
        Collection<Qualificatif> qls = QualificatiSer.findallqua();
        logger.info("liste des utilisateurs : " + qls.toString());
        return new ResponseEntity<Collection<Qualificatif>>(qls, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Qualificatif> getQuestion(@PathVariable  Integer id) {
        try{

            return  new ResponseEntity<>( QualificatiSer.getbyid(id).get(), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            return  new ResponseEntity<>(new Qualificatif(), HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/qualifinqst/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getQuaInQues(@PathVariable  Integer id)
    {
        return  new ResponseEntity<>( QualificatiSer.FindQualifinQsts(id), HttpStatus.OK);

    }

    @PostMapping("/create")
    ResponseEntity<Qualificatif> CreateQualificatif(@RequestBody Qualificatif newQualificatif) {

        return  new ResponseEntity<Qualificatif>(QualificatiSer.Create(newQualificatif), HttpStatus.OK);
    }
    @PostMapping(value = "/update")
    public ResponseEntity<Boolean> updateQual(@RequestBody Qualificatif qualmd) {
        return  new ResponseEntity<>( QualificatiSer.UpdateQual(qualmd), HttpStatus.OK);

    }
    @DeleteMapping (value = "/supprimer/{id}")

    public ResponseEntity<Boolean> supprimerQuali(@PathVariable int id) throws SprintException {
        if (QualificatiSer.FindQualifinQsts(id) != null ) {
            logger.debug("Qualificatif "+id+" Existe in Question ");
            throw new SprintException("Violation", "Suppression qualifcatif "+id+" Interdit Existe in Question ",HttpStatus.CONFLICT);
        }
        QualificatiSer.supprimerqua(id);
        logger.debug("L'utilisateur avec l'identifiant " + id + " supprimé");
        return new ResponseEntity<>(HttpStatus.GONE);


    }


}
