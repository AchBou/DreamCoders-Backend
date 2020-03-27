package Demo.demo.QualificatifTestUnit;
import Demo.DAO.EnseignantDAO;
import Demo.DAO.QualificatifDAO;
import Demo.DAO.QuestionDAO;
import Demo.model.Qualificatif;
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
public class QualificatifTestUnit {

    private QualificatifDAO qualifdao;
    @Autowired
    private QualificatifService quaService;

    @BeforeEach
    void initUseCase() {

        quaService  =new QualificatifService(qualifdao);
    }
    @Test
    public void TestCreateQualif() {

        Qualificatif qua= new Qualificatif("InsuffisantTest","ExceccifTest");
        Qualificatif sauv =quaService.Create(qua);
        assert(sauv.getMaximal()).equals("ExceccifTest");

    }
    @Test
    public void TestUpdatequa() {
        Qualificatif qua= new Qualificatif("InsuffisantTestm","ExceccifTestm");
        Qualificatif sauv =quaService.Create(qua);
        sauv.setMaximal("ExceccifTestMod");
        quaService.UpdateQual(sauv);
       assert(quaService.getbyid(sauv.getIdQualificatif()).get().getMaximal().equals(sauv.getMaximal()));
    }
    @Test
    public void TestDeleteQua() {
         Qualificatif qua= new Qualificatif("InsuffisantTestm","ExceccifTestm");
        Qualificatif sauv =quaService.Create(qua);
        assertSame(quaService.getbyid(sauv.getIdQualificatif()).equals("false"),false);
    }
}
