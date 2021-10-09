package co.com.sofka.runner.practiceform;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.practiceform.PracticeForm;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.Gender;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends WebUI {
    /**Atributos*/
    private PracticeFormModel practiceFormModel;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    /**Lo que se hace antes de testear*/
    @BeforeEach
    public void setUp(){
        try{
            generalSetUp();
            practiceFormModel = new PracticeFormModel();
            practiceFormModel.setName("Teodoro");
            practiceFormModel.setLastName("Calle");
            practiceFormModel.setMobile("3127723718");
            practiceFormModel.setGender(Gender.MALE);
        }catch (Exception exception){
            quitDriver();
        }
    }

    /**Lo que se hace durante el test*/
    @Test
    public void practiceFormTestMandatoryFields(){
        try{
            PracticeForm practiceForm = new PracticeForm(driver, practiceFormModel);
            practiceForm.fillStudentForm();
            Assertions.assertEquals(practiceForm.IsRegistrationDone(), forSubmittedForm(),ASSERTION_EXCEPTION_MESSAGE);
        }catch (Exception exception){
            quitDriver();
        }
    }

    /**Lo que hace despues del test*/
    @AfterEach
    public void tearDown(){
        quitDriver();
    }

    private List<String> forSubmittedForm(){
        List<String> submitedFormResult = new ArrayList<String>();
        submitedFormResult.add(practiceFormModel.getName() + " " + practiceFormModel.getLastName());
        submitedFormResult.add(practiceFormModel.getGender().getValue());
        submitedFormResult.add(practiceFormModel.getMobile());
        return submitedFormResult;
    }


}
