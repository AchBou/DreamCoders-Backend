package Demo.controllers;

import Demo.model.*;
import Demo.services.UEService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ue")
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
    
    
    @RequestMapping(value = "{code_ue}/{code_formation}/ec", method = RequestMethod.GET)
    public Response getECByCodeUE(@PathVariable("code_ue") String codeUE, @PathVariable("code_formation") String codeForm) {
        Response.Status s = Response.Status.OK;
        List<ElementConstitutif> listeUnitesEnseignement = ueService.findECByUE(codeUE, codeForm);
        if(listeUnitesEnseignement.isEmpty()) s = Response.Status.NOT_FOUND;
        return Response
                .status(s)
                .entity(listeUnitesEnseignement)
                .build();
    }
}
