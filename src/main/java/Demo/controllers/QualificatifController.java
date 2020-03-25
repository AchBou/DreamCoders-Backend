package Demo.controllers;
import Demo.model.Qualificatif;
import Demo.model.Question;
import Demo.services.QualificatifService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
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
        try{
            return  new ResponseEntity<>(  QualificatiSer.findallqua(), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Qualificatif>(),headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Qualificatif>(),headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Qualificatif>(),headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Qualificatif>(),headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Qualificatif> getQuestion(@PathVariable  Integer id) {
        try{

            return  new ResponseEntity<>(QualificatiSer.getbyid(id).get(), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new Qualificatif(),headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new Qualificatif(),headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new Qualificatif(),headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new Qualificatif(),headers, HttpStatus.BAD_REQUEST);
        }

    }
    @RequestMapping(value = "/qualifinqst/{id}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> getQuaInQues(@PathVariable  Integer id)
    {
        try{
            return  new ResponseEntity<>(QualificatiSer.FindQualifinQsts(id), HttpStatus.OK);
        }
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.BAD_REQUEST);
        }


    }

    @PostMapping("/create")
    ResponseEntity<Qualificatif> CreateQualificatif(@RequestBody Qualificatif newQualificatif) {
        try{

            return  new ResponseEntity<>(QualificatiSer.Create(newQualificatif), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Qualificatif(),headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Qualificatif(),headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Qualificatif(),headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Qualificatif(),headers, HttpStatus.BAD_REQUEST);
        }
   }



    @PostMapping(value = "/update")
    public ResponseEntity<Boolean> updateQual(@RequestBody Qualificatif qualmd) {
        try{
            return  new ResponseEntity<>( QualificatiSer.UpdateQual(qualmd), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping (value = "/supprimer/{id}")

    public ResponseEntity<Boolean> supprimerQuali(@PathVariable int id) {

        try {

            return new ResponseEntity<>(QualificatiSer.supprimerqua(id), HttpStatus.OK);
        } catch (java.util.NoSuchElementException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(false, headers, HttpStatus.NOT_FOUND);
        } catch (NotFoundException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(false, headers, HttpStatus.NOT_FOUND);
        } catch (BadRequestException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(false, headers, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(false, headers, HttpStatus.BAD_REQUEST);
        }


    }
}
