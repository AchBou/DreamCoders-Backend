package Demo.controllers;

import Demo.model.Formation;
import Demo.model.PromotionPK;
import Demo.model.UniteEnseignement;
import Demo.model.UniteEnseignementPK;
import Demo.modelPerso.FormationPers;
import Demo.services.FormationService;
import Demo.services.PromotionService;
import Demo.services.UEService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/form")
@CrossOrigin
public class FormationController {
    @Autowired
    FormationService formationService;

    @Autowired
    PromotionService promotionService;
    
    @Autowired
    UEService ueService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)

    public Response getAllFormations() {
        List<Formation> listFormation = formationService.getAllFormations();
        return Response
                .status(Response.Status.OK)
                .entity(listFormation)
                .build();
    }

    @RequestMapping(value = "{code_formation}/promo", method = RequestMethod.GET)
    public Response getPromByForm(@PathVariable("code_formation") String codeForm) {
        List<PromotionPK> promotionPK = promotionService.findPromoByFormation(codeForm);
        return Response
                .status(Response.Status.OK)
                .entity(promotionPK)
                .build();
    }
    
    @RequestMapping(value = "{code_formation}/ue", method = RequestMethod.GET)
    public Response getUEByForm(@PathVariable("code_formation") String codeForm) {
        List<UniteEnseignement> uniteEnseignement = ueService.findUEByFormation(codeForm);
        return Response
                .status(Response.Status.OK)
                .entity(uniteEnseignement)
                .build();
    }
}
