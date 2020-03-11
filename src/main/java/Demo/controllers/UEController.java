package Demo.controllers;

import Demo.model.ElementConstitutifPK;
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
public class UEController {
    @Autowired
    UEService ueService;

   /* @RequestMapping(value = "/all", method = RequestMethod.GET)

    public Response getAllUnitesEnseignements() {
        List<UniteEnseignementPK> listUEs = UEService.findAllUEs();
        return Response
                .status(Response.Status.OK)
                .entity(listUEs)
                .build();
    } */
    
    
    @RequestMapping(value = "ue/{code_ue}/ec", method = RequestMethod.GET)
    public Response getECByCodeUE(@PathVariable("code_ue") String codeUE) {
        List<ElementConstitutifPK> listeUnitesEnseignement = ueService.findECByUE(codeUE);
        return Response
                .status(Response.Status.OK)
                .entity(listeUnitesEnseignement)
                .build();
    }
}
