package Demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Demo.DAO.*;
import Demo.model.*;
import Demo.modelPerso.EvaluationPers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
         evaluation.setAnne_Universitaire(eva.getAnnee_universitaire());
         evaluation.setCode_formation(eva.getCode_formation());
         evaluation.setCode_eu(eva.getCode_ue());
         evaluation.setCode_ec(eva.getCode_ec());
         try{
             evaluation = evalDao.save(evaluation);
         }catch (Exception ex){
             return null;
         }
         return evaluation;
     }

}
