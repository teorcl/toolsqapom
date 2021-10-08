package co.com.sofka.page.practiceform;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.commond.CommonActionsOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class PracticeForm  extends CommonActionsOnPages {
    private final PracticeFormModel practiceFormModel;
    /**Atributos*/
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By genderMale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private final By genderFamale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label");
    private final By genderOther = By.xpath("//*[@id=\"gender-radio-3\"]");
    private final By mobile = By.id("userNumber");
    private final By submit = By.id("submit");

    /**Constructor*/
    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel) {
        super(driver);
        this.practiceFormModel = practiceFormModel;
    }

    public void fillStudentForm(){
        clear(name);
        type(name,practiceFormModel.getName());

        clear(lastName);
        type(lastName,practiceFormModel.getLastName());

        switch (practiceFormModel.getGender()){
            case MALE:
                clickOn(genderMale);
                break;
            case FEMALE:
                clickOn(genderFamale);
                break;
            case OTHER:
                clickOn(genderOther);
                break;
            default:
        }

        clear(mobile);
        type(mobile,practiceFormModel.getMobile());

        doSubmit(submit);

    }

    /**For Assertions test case, Para el caso de prueba de aserciones*/
    private final By studentNameAssertion = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]");
    private final By genderAssertion = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]");
    private final By mobileAssertion = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]");

    public List<String> IsRegistrationDone() {
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(studentNameAssertion).trim());
        submitedFormResult.add(getText(genderAssertion).trim());
        submitedFormResult.add(getText(mobileAssertion).trim());
        return submitedFormResult;
    }


}
