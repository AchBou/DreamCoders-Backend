package Demo.controllers;
import Demo.model.Evaluation;
import Demo.model.Qualificatif;
import Demo.model.Question;
import Demo.modelPerso.EvaluationPers;
import Demo.services.QualificatifService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Exception.*;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/qualicatif")
public class QualificatifController {
    private static final Logger logger = LoggerFactory.getLogger(QualificatifController.class);
    @Autowired
    QualificatifService QualificatiSer;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Qualificatif>> getAllQualif()
    {
        return  new ResponseEntity<>(  QualificatiSer.findallqua(), HttpStatus.OK);

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
    public Response CreateQualificatif(@RequestBody Qualificatif newQualificatif) {
        try {
            Qualificatif qualif = this.QualificatiSer.Create(newQualificatif);
            return Response.ok(qualif).build();
        }
        catch (NotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        catch (BadRequestException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

    }

    @PostMapping(value = "/update")
    public ResponseEntity<Boolean> updateQual(@RequestBody Qualificatif qualmd) {
        return  new ResponseEntity<>( QualificatiSer.UpdateQual(qualmd), HttpStatus.OK);

    }
    @DeleteMapping (value = "/supprimer/{id}")

    public ResponseEntity<Boolean> supprimerQuali(@PathVariable int id) throws SprintException{
        if (QualificatiSer.FindQualifinQsts(id) != null ) {
            logger.debug("Qualificatif "+id+" Existe in Question ");
            throw new SprintException("Violation", "Suppression qualifcatif "+id+" Interdit Existe in Question ",HttpStatus.CONFLICT);
        }
        QualificatiSer.supprimerqua(id);
        logger.debug("L'utilisateur avec l'identifiant " + id + " supprimé");
        return new ResponseEntity<>(HttpStatus.GONE);


    }


}
