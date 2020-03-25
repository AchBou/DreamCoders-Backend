package Demo.controllers;

import java.util.List;


//import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.ResponseBody;

import Demo.model.Rubrique;
import Demo.services.RubriqueService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rubrique")
public class RubriqueController {
    @Autowired
    RubriqueService RubService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Rubrique>> getAllRubriques() {
        return  new ResponseEntity<>(  RubService.getAllRubriques(), HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Rubrique> getRubrique(@PathVariable Integer id) {
        try{

        return  new ResponseEntity<>( RubService.FindRubrique(id).get(), HttpStatus.OK);}
        catch(java.util.NoSuchElementException e){
        return  new ResponseEntity<>( new Rubrique(), HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/linked/{id}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> TestRubrique(@PathVariable Integer id) {
        return  new ResponseEntity<>( RubService.TestRubLink(id), HttpStatus.OK);

    }
    @PostMapping(value = "/create")
    public ResponseEntity<Rubrique> CreateRubrique(@RequestBody Rubrique newRubrique) {
        return  new ResponseEntity<>( RubService.CreateRubrique(newRubrique), HttpStatus.OK);

    }
    @PostMapping(value = "/update")
    public ResponseEntity<Boolean> UpdateRubrique(@RequestBody Rubrique newRubrique) {
        return  new ResponseEntity<>( RubService.UpdateRubrique(newRubrique), HttpStatus.OK);


    }
    @DeleteMapping (value = "/supprimer/{id}")
    public ResponseEntity<Boolean> RubriqueQuestion(@PathVariable int id) {

        return  new ResponseEntity<>( RubService.Delete(id), HttpStatus.OK);

    }




}
