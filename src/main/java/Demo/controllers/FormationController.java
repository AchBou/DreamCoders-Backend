package Demo.controllers;

import Demo.model.Formation;
import Demo.model.PromotionPK;
import Demo.modelPerso.FormationPers;
import Demo.services.FormationService;
import Demo.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/form")
public class FormationController {
    @Autowired
    FormationService formationService;

    @Autowired
    PromotionService promotionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)

    public Response getAllFormations() {
        List<FormationPers> listFormation = formationService.getAllFormations();
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
}
