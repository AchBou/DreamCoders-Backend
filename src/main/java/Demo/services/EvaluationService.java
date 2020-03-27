package Demo.services;

import java.util.List;

import Demo.DAO.EvaluationDAO;
//import Demo.modelPerso.ListeEvalForm;
import Demo.model.Question;
import Demo.DAO.*;
import Demo.model.*;
import Demo.modelPerso.EvaluationPers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;


@Service
public class EvaluationService {
	 @Autowired

     EvaluationDAO evaluationDAO;

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
         List<Evaluation> ev = this.evaluationDAO.findAll(orderBy("debutReponse"));
         return ev;
     }
 
     public Evaluation addEvaluation(EvaluationPers eva) {
         //System.out.println(eva.toString());
         Enseignant en = ensDao.getOne(1); //Phillipe Saliou
         Evaluation evaluation = new Evaluation();
         evaluation.setEnseignant(en);
         evaluation.setDebutReponse(eva.getDebut_reponse());
         evaluation.setFinReponse(eva.getFin_reponse());
         evaluation.setDesignation(eva.getDesignation());
         evaluation.setNoEvaluation(eva.getNo_evaluantion());
         evaluation.setPeriode(eva.getPeriode());
         evaluation.setEtat(etatDAO.getOne(eva.getEtat()));
         evaluation.setUniteEnseignement(ueDao.getOne(new UniteEnseignementPK(eva.getCode_formation(), eva.getCode_ue())));
         if(eva.getCode_ec()!=null && !eva.getCode_ec().isEmpty()){
             evaluation.setElementConstitutif(ecDao.getOne(new ElementConstitutifPK(eva.getCode_formation(), eva.getCode_ue(), eva.getCode_ec())));
         }
         Promotion p = this.promService.getCurrentPromo(eva.getCode_formation());
         if(p!=null){
             evaluation.setPromotion(p);
         }
         else{
             throw new NotFoundException("Aucune promotion actuelle de la formation que vous avez choisie");
         }
         try{
             evaluation = evaluationDAO.save(evaluation);
             evaluation = evaluationDAO.getOne(evaluation.getIdEvaluation());
         }catch (Exception ex){
             if(ex.getMessage().contains("EVE_EVE_UK")){
                 throw new BadRequestException("Cette évaluation existe déjà");
             }
             throw ex;
         }
         return evaluation;
     }
    //update Evaluation****
    public boolean UpdateEvaluation(Evaluation eva) {
        if (this.evaluationDAO.findById(eva.getIdEvaluation()).isPresent()) {
            this.evaluationDAO.save(eva);
            return true ;
        }
        return false;
    }

    public Evaluation publierEvaluation(Evaluation eva) {
        Evaluation evaluation = evaluationDAO.getOne(eva.getIdEvaluation());
        if(evaluation.getRubriqueEvaluations().size() < 4){
            throw new RuntimeException("Vous devez avoir au minimum 4 rubriques dans cette évaluation pour pouvoir la publier");
        }
        if(evaluation.getRubriqueEvaluations().size() > 8){
                throw new RuntimeException("Vous devez avoir au maximum 8 rubriques dans cette évaluation pour pouvoir la publier");
            }
            for (RubriqueEvaluation re :
                evaluation.getRubriqueEvaluations()) {
            if (re.getQuestionEvaluations().isEmpty()) {
                throw new RuntimeException("Aucune rubrique ne doit être vide");
            }
        }
        evaluation.setEtat(etatDAO.getOne("DIS"));
        evaluation = evaluationDAO.save(evaluation);
        return evaluation;
    }
}
