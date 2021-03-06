package co.com.sofka.stepdefinition.practiceform.opt2;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.practiceform.PracticeForm;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.Gender;
import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;


import java.util.ArrayList;
import java.util.List;

public class PracticeFormCucumberOpt2StepDefinition extends WebUI implements En {

    private PracticeFormModel practiceFormModel;
    private PracticeForm practiceForm;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    public PracticeFormCucumberOpt2StepDefinition() {

        Given("Que el empleado administrativo se encuentra en la página web de los ingresos de estudiantes", () -> {
            try{
                generalSetUp();
                practiceFormModel = new PracticeFormModel();
                practiceFormModel.setName("Teodoro");
                practiceFormModel.setLastName("Calle");
                practiceFormModel.setGender(Gender.MALE);
                practiceFormModel.setMobile("3127723718");
            }catch (Exception exception){
                quitDriver();
            }
        });

        When("El empleado administrativo ingresa los campos obligatorios y confirma la acción", () -> {
            try{
                practiceForm = new PracticeForm(driver, practiceFormModel);
                practiceForm.fillStudentForm();
            }catch (Exception exception){
                quitDriver();
            }
        });

        Then("El sistema deberá mostrar por pantalla el registro del estudiante ingresado", () -> {
            try{

                Assertions.assertEquals(practiceForm.IsRegistrationDone(),
                        forSubmittedForm(),
                        ASSERTION_EXCEPTION_MESSAGE
                );

            }catch (Exception exception){
                quitDriver();
            }
            finally {
                quitDriver();
            }
        });

    }

    private List<String> forSubmittedForm(){
        List<String> submitedFormResult = new ArrayList<String>();
        submitedFormResult.add(practiceFormModel.getName() + " " + practiceFormModel.getLastName());
        submitedFormResult.add(practiceFormModel.getGender().getValue());
        submitedFormResult.add(practiceFormModel.getMobile());
        return submitedFormResult;
    }


}
