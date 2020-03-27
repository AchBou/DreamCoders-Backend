package Demo.controllers;
import Demo.model.Question;
import Demo.services.QuestionService;
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
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService QuestionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        try{
            return  new ResponseEntity<>(  QuestionService.getQuestions(), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Question>(),headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Question>(),headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Question>(),headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Question>(),headers, HttpStatus.BAD_REQUEST);
        }

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestion(@PathVariable  Integer id) {
        try{

            return  new ResponseEntity<>(QuestionService.findById(id).get(), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new Question(),headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new Question(),headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new Question(),headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(new Question(),headers, HttpStatus.BAD_REQUEST);
        }

    }
    @RequestMapping(value = "/qstinrub/{id}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> getQuestionInRub(@PathVariable  Integer id)
    {
        try{
            return  new ResponseEntity<>( QuestionService.findQuestifExistinRub(id), HttpStatus.OK);
        }
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Message d'erreur:", e.getMessage());
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

   @RequestMapping(value = "/qstinqualif/{id}", method = RequestMethod.GET)
   public ResponseEntity<Boolean> getQuestionInq(@PathVariable  Integer id)
   {
       try{
           return  new ResponseEntity<>( QuestionService.FindQsthasqualif(id), HttpStatus.OK);
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

    @RequestMapping(value = "/findqstinEva/{id}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> findQstinEva(@PathVariable Integer id)
    {
        return  new ResponseEntity<> ( QuestionService.FindQstinEva(id), HttpStatus.OK);

    }
    @PostMapping("/create")
    ResponseEntity<Question> CreateQuestion(@RequestBody Question newQuestion) {
        try{

            return  new ResponseEntity<>(QuestionService.Create(newQuestion), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Question(),headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Question(),headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Question(),headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Question(),headers, HttpStatus.BAD_REQUEST);
        } }


    @PostMapping(value = "/update")
    public ResponseEntity<Boolean> updateQst(@RequestBody Question nvqst) {
        try{
            return  new ResponseEntity<>( QuestionService.UpdateQuestion(nvqst), HttpStatus.OK);}
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

    public ResponseEntity<Boolean> supprimerQuestion(@PathVariable int id) {
        try {

            return new ResponseEntity<>(QuestionService.supprimer(id), HttpStatus.OK);
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
