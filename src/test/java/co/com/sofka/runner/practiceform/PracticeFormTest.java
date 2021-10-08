package co.com.sofka.runner.practiceform;

import co.com.sofka.page.practiceform.PracticeForm;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest {
    /**Atributos*/
    private WebDriver driver;

    /**Lo que se hace antes de testear*/
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/windows/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    /**Lo que se hace durante el test*/
    @Test
    public void practiceFormTestMandatoryFields(){
        PracticeForm practiceForm = new PracticeForm(driver);
        practiceForm.typeName("Teodoro");
        practiceForm.typeLastName("Calle");
        practiceForm.clickGenderMale();
        practiceForm.typeNumber("3127723718");
        practiceForm.doSubmit();

        Assertions.assertEquals(practiceForm.IsRegistrationDone(), forSubmittedForm(),"Los valores suministrados no son los esperados.");
    }

    /**Lo que hace despues del test*/
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    private List<String> forSubmittedForm(){
        List<String> submitedFormResult = new ArrayList<String>();
        submitedFormResult.add("Teodoro Calle");
        submitedFormResult.add("Male");
        submitedFormResult.add("3127723718");
        return submitedFormResult;
    }


}
