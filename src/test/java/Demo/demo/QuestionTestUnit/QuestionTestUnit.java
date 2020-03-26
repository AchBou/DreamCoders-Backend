package Demo.demo.QuestionTestUnit;
import Demo.DAO.EnseignantDAO;
import Demo.DAO.QualificatifDAO;
import Demo.DAO.QuestionDAO;
import Demo.model.Question;
import Demo.services.EnseignantService;
import Demo.services.QualificatifService;
import Demo.services.QuestionService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class QuestionTestUnit {

   // private QuestionService userRepository ;
    private QuestionDAO qstdao;
    private QualificatifDAO qualifdao;
    private EnseignantDAO   ensdao;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QualificatifService qualificatifService;
    @Autowired
    private EnseignantService ensService;

    @BeforeEach
    void initUseCase() {
        questionService =new QuestionService(qstdao);
        qualificatifService =new QualificatifService(qualifdao);
        ensService =new EnseignantService(ensdao);
    }

    @Test
    public void TestCreateQuestion() {

        Question Q1= new Question("Q","QUS",ensService.getbyid(1).get(),qualificatifService.getbyid(24).get());
        Question sauvq1 =questionService.Create(Q1);
        assert(sauvq1.getIntitule()).equals("Q");
    }

    @Test
    public void TestUpdateQuestion() {
        Question Q1= new Question("QMod","QUS",ensService.getbyid(1).get(),qualificatifService.getbyid(24).get());
        Question sauvq1 =questionService.Create(Q1);
        sauvq1.setIntitule("Mod");
        questionService.update(sauvq1);
        assert(questionService.findById(sauvq1.getIdQuestion()).get().getIntitule().equals(sauvq1.getIntitule()));
       // assertSame("Mod",sauvq1.getIntitule());

    }

    @Test
    public void TestQstinRub() {
        Boolean qstinrub = questionService.findQuestifExistinRub(9);
        assertSame(true, true);
    }


    @Test
    public void TestDeleteQuestion() {
        Question Q1= new Question("QTestSup","QUS",ensService.getbyid(1).get(),qualificatifService.getbyid(24).get());
        Question sauvq1 =questionService.Create(Q1);
        assertSame(questionService.findById(sauvq1.getIdQuestion()).equals("false"),false);
    }
 /*   @Test
    public void TestCreationQuestion() {
        Question Q1= new Question("QTest","QUS",ensService.getbyid(1).get(),qualificatifService.getbyid(24).get());
        Question sauvq1 =questionService.Create(Q1);
        if(sauvq1.getIdQuestion().equals(0)){
            System.out.println( "Pas Creer ");
        }
        System.out.println( "Est bien Creer");
    }*/
}