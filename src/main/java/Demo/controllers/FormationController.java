package Demo.controllers;

import Demo.model.Formation;
import Demo.modelPerso.FormationPers;
import Demo.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/form")
public class FormationController {
    @Autowired
    FormationService formationService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)

    public Response getAllFormations() {
        List<FormationPers> listFormation = formationService.getAllFormations();
        return Response
                .status(Response.Status.OK)
                .entity(listFormation)
                .build();
    }
}
