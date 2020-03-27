package Demo.demo;
import Demo.DAO.EnseignantDAO;
import Demo.DAO.QualificatifDAO;
import Demo.DAO.QuestionDAO;
import Demo.DAO.RubriqueDAO;
import Demo.model.Question;
import Demo.model.Rubrique;
import Demo.services.EnseignantService;
import Demo.services.QualificatifService;
import Demo.services.QuestionService;
import Demo.services.RubriqueService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DemoTestRubs  {

    // private QuestionService userRepository ;
    private RubriqueDAO Rubdao;
    private QualificatifDAO qualifdao;
    private EnseignantDAO   ensdao;
    @Autowired
    private RubriqueService RubriqueService;
    @Autowired
    private QualificatifService qualificatifService;
    @Autowired
    private EnseignantService ensService;

    @BeforeEach
    void initUseCase() {
        RubriqueService =new RubriqueService(Rubdao);
        RubriqueService =new RubriqueService(Rubdao);
        ensService =new EnseignantService(ensdao);
    }

    @Test
    public void TestCreateRubrique() {
        BigDecimal BigDec1 = new BigDecimal("122");
        Rubrique Q1= new Rubrique("RBS","DEs",ensService.getbyid(7).get(),BigDec1);
        Rubrique sauvq1 =RubriqueService.CreateRubrique(Q1);
        assert(sauvq1.getDesignation()).equals("DEs");
    }

    @Test
    public void TestUpdateRubrique() {
        BigDecimal BigDec1 = new BigDecimal("122");
        Rubrique Q1= new Rubrique("RBS","TestUp",ensService.getbyid(7).get(),BigDec1);
        Rubrique sauvq1 =RubriqueService.CreateRubrique(Q1);
        sauvq1.setDesignation("Tested");
        RubriqueService.UpdateRubrique(sauvq1);
        assert(RubriqueService.FindRubrique(sauvq1.getIdRubrique()).get().getDesignation().equals(sauvq1.getDesignation()));

    }


    @Test
    public void TestDeleteRubrique() {
        BigDecimal BigDec1 = new BigDecimal("122");
        Rubrique Q1= new Rubrique("RBS","TestUp",ensService.getbyid(7).get(),BigDec1);
        Rubrique sauvq1 =RubriqueService.CreateRubrique(Q1);

        assertSame(RubriqueService.FindRubrique(sauvq1.getIdRubrique()).equals("false"),false);
    }

}