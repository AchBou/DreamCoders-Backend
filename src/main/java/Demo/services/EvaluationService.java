package Demo.services;

import java.util.List;

<<<<<<< HEAD
import Demo.DAO.EvaluationDAO;
//import Demo.modelPerso.ListeEvalForm;
import Demo.model.Question;
=======
import Demo.DAO.*;
import Demo.model.*;
import Demo.modelPerso.EvaluationPers;
>>>>>>> remotes/origin/master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;


@Service
public class EvaluationService {
	 @Autowired
<<<<<<< HEAD
     EvaluationDAO evaluationDAO;
 
     public List<Evaluation> getAllEvals()
     {
         return this.evaluationDAO.findAll();
     }
 
     public Evaluation addEvaluation(Evaluation eva) {
         return this.evaluationDAO.save(eva);
=======
     EvaluationDAO evalDao;
    @Autowired
	 EnseignantDAO ensDao;
    @Autowired
	 ECDAO ecDao;
    @Autowired
	 UEDAO ueDao;
    @Autowired
	 PromotionDAO promDao;
    @Autowired
    PromotionService promService;
    @Autowired
    EtatEvaluationDAO etatDAO;

    private Sort orderBy(String property){
        return Sort.by(Sort.Direction.DESC, property);
    }
     public List<Evaluation> getAllEvals()
     {
         List<Evaluation> ev = this.evalDao.findAll(orderBy("debutReponse"));
         for (Evaluation evaluation:
              ev) {
             evaluation.setEtat(etatDAO.getOne(evaluation.getEtat()).getSignification());
         }
         return ev;
     }
 
     public Evaluation addUser(EvaluationPers eva) {
         //System.out.println(eva.toString());
         Enseignant en = ensDao.getOne(1); //Phillipe Saliou
         Evaluation evaluation = new Evaluation();
         evaluation.setEnseignant(en);
         evaluation.setDebutReponse(eva.getDebut_reponse());
         evaluation.setFinReponse(eva.getFin_reponse());
         evaluation.setDesignation(eva.getDesignation());
         evaluation.setNoEvaluation(eva.getNo_evaluantion());
         evaluation.setPeriode(eva.getPeriode());
         evaluation.setEtat(eva.getEtat());
         evaluation.setCode_formation(eva.getCode_formation());
         evaluation.setCode_eu(eva.getCode_ue());
         evaluation.setCode_ec(eva.getCode_ec());
         Promotion p = this.promService.getCurrentPromo(eva.getCode_formation());
         if(p!=null){
             evaluation.setPromotion(p);
         }
         else{
             throw new NotFoundException("Aucune promotion actuelle de la formation que vous avez choisie");
         }
         try{
             evaluation = evalDao.save(evaluation);
         }catch (Exception ex){
             if(ex.getMessage().contains("EVE_EVE_UK")){
                 throw new BadRequestException("Cette evaluation existe deja");
             }
             throw ex;
         }
         return evaluation;
     }
    //update Evaluation
    public boolean UpdateEvaluation(Evaluation eva) {
        if (this.evaluationDAO.findById(eva.getIdEvaluation()).isPresent()) {
            this.evaluationDAO.save(eva);
            return true ;
        }
        return false;
    }
}
