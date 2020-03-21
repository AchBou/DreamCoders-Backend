package Demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Demo.DAO.*;
import Demo.model.*;
import Demo.modelPerso.EvaluationPers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;


@Service
public class EvaluationService {
	 @Autowired
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

     public List<Evaluation> getAllEvals()
     {
         return this.evalDao.findAll();
     }
 
     public Evaluation addUser(EvaluationPers eva) {
         //System.out.println(eva.toString());
         Enseignant en = ensDao.getOne(1);
         Evaluation evaluation = new Evaluation();
         evaluation.setEnseignantt(en); //Phillipe Saliou
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
             evaluation.setPromotionn(p);
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

}
