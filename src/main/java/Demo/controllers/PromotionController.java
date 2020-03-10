package Demo.controllers;


import Demo.model.PromotionPK;
import Demo.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/prom")
public class PromotionController {

    @Autowired
    PromotionService promotionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Response getPromByForm(@RequestParam String codeForm) {
        List<PromotionPK> promotionPK = promotionService.findPromoByFormation(codeForm);
        return Response
                .status(Response.Status.OK)
                .entity(promotionPK)
                .build();
    }
}
