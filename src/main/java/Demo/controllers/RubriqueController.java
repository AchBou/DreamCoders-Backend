package Demo.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Demo.model.Rubrique;
import Demo.services.RubriqueService;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rubrique")
public class RubriqueController {
    @Autowired
    RubriqueService RubService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)

    public ResponseEntity<List<Rubrique>> getAllRubriques() {

        try{

            return  new ResponseEntity<>(  RubService.getAllRubriques(), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Rubrique>(),headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Rubrique>(),headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Rubrique>(),headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Rubrique>(),headers, HttpStatus.BAD_REQUEST);
        }


    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Rubrique> getRubrique(@PathVariable Integer id) {
        try{

        return  new ResponseEntity<>( RubService.FindRubrique(id).get(), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Rubrique(),headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Rubrique(),headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Rubrique(),headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Rubrique(),headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/linked/{id}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> TestRubrique(@PathVariable Integer id) {
        try{
            return  new ResponseEntity<>( RubService.TestRubLink(id), HttpStatus.OK);}
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
    @PostMapping(value = "/create")
    public ResponseEntity<Rubrique> CreateRubrique(@RequestBody Rubrique newRubrique) {
        try{

            return  new ResponseEntity<>( RubService.CreateRubrique(newRubrique), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Rubrique(),headers, HttpStatus.NOT_FOUND);
        }
        catch (NotFoundException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Rubrique(),headers, HttpStatus.NOT_FOUND);
        }
        catch (BadRequestException e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Rubrique(),headers, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new Rubrique(),headers, HttpStatus.BAD_REQUEST);
        }


    }
    @PostMapping(value = "/update")
    public ResponseEntity<Boolean> UpdateRubrique(@RequestBody Rubrique newRubrique) {
        try{

            return  new ResponseEntity<>( RubService.UpdateRubrique(newRubrique), HttpStatus.OK);}
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
    public ResponseEntity<Boolean> RubriqueQuestion(@PathVariable int id) {

        try{

            return  new ResponseEntity<>( RubService.Delete(id), HttpStatus.OK);
        }
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
            headers.set("message",e.getMessage());
            return new ResponseEntity<>(false,headers, HttpStatus.BAD_REQUEST);
        }
    }




}
