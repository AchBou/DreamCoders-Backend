package Demo.controllers;

import Demo.DAO.EvaluationDAO;
import Demo.DAO.RubriqueDAO;
import Demo.model.Evaluation;
import Demo.model.Rubrique;
import Demo.model.RubriqueEvaluation;
import Demo.services.EvaluationService;
import Demo.services.RubriqueEvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rubriqueEval")
public class RubriqueEvalController {

    @Autowired
    RubriqueEvalService rubriqueEvalService;

    @Autowired
    EvaluationService evaluationService;

    @Autowired

    EvaluationDAO evaluationDAO;
    @Autowired
    RubriqueDAO rubriqueDAO;


    //listee ***********
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Rubrique>> getRubriqueByEval(@PathVariable long id) {
        try {
            List<Rubrique> rubriques = new ArrayList<>();

            rubriqueEvalService.findRubriqueByEval(id).forEach(rubriqueEvaluation -> {
                rubriques.add(rubriqueEvaluation.getRubrique());
            });
            return new ResponseEntity<>(rubriques, HttpStatus.OK);
        } catch (java.util.NoSuchElementException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Rubrique>(), headers, HttpStatus.NOT_FOUND);
        } catch (
                NotFoundException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Rubrique>(), headers, HttpStatus.NOT_FOUND);
        } catch (
                BadRequestException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Rubrique>(), headers, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new ArrayList<Rubrique>(), headers, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = "/create/{idEvaluation}/{idRubrique}")
    public ResponseEntity<RubriqueEvaluation> createRubriqueEval(@PathVariable long idEvaluation, @PathVariable int idRubrique) {
        try {
            Integer iInteger = new Integer(idRubrique);

            RubriqueEvaluation rubriqueEvaluation = new RubriqueEvaluation();
            rubriqueEvaluation.setEvaluation(evaluationDAO.getOne(idEvaluation));
            rubriqueEvaluation.setRubrique(rubriqueDAO.getOne(iInteger));
            rubriqueEvaluation.setOrdre(BigDecimal.valueOf(0));


            return new ResponseEntity<>(rubriqueEvalService.createRubEval(rubriqueEvaluation), HttpStatus.OK);
        } catch (java.util.NoSuchElementException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new RubriqueEvaluation(),headers, HttpStatus.NOT_FOUND);
        } catch (NotFoundException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new RubriqueEvaluation(),headers, HttpStatus.NOT_FOUND);
        } catch (BadRequestException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new RubriqueEvaluation(),headers, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("message", e.getMessage());
            return new ResponseEntity<>(new RubriqueEvaluation(),headers, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(value = "/supprimer/{idEvaluation}/{idRubrique}")

    public ResponseEntity supprimerRubriqueEval(@PathVariable long idEvaluation, @PathVariable long idRubrique) {
        try {
            Integer idrub = (int) (long) idRubrique;
            rubriqueEvalService.deleteRubrique(idEvaluation, idrub);

            return new ResponseEntity<>(HttpStatus.OK);

        }catch(java.util.NoSuchElementException e){
        HttpHeaders headers = new HttpHeaders();
        headers.set("message", e.getMessage());
        return new ResponseEntity<>(null,headers, HttpStatus.NOT_FOUND);
    }
        catch (NotFoundException e){
        HttpHeaders headers = new HttpHeaders();
        headers.set("message", e.getMessage());
        return new ResponseEntity<>(null,headers, HttpStatus.NOT_FOUND);
    }
        catch (BadRequestException e){
        HttpHeaders headers = new HttpHeaders();
        headers.set("message", e.getMessage());
        return new ResponseEntity<>(null,headers, HttpStatus.BAD_REQUEST);
    }
        catch (Exception e){
        HttpHeaders headers = new HttpHeaders();
        headers.set("message", e.getMessage());
        return new ResponseEntity<>(null,headers, HttpStatus.BAD_REQUEST);
    }
    }
}