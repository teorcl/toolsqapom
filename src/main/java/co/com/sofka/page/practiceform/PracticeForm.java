package co.com.sofka.page.practiceform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class PracticeForm {

    /**Atributos*/
    private final WebDriver driver;
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By genderMale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private final By genderFamale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label");
    private final By genderOther = By.xpath("//*[@id=\"gender-radio-3\"]");
    private final By mobile = By.id("userNumber");
    private final By submit = By.id("submit");

    /**Constructor*/
    public PracticeForm(WebDriver driver) {
        this.driver = driver;
    }

    /**For Assertions test case, Para el caso de prueba de aserciones*/
    private final By studentNameAssertion = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]");
    private final By genderAssertion = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]");
    private final By mobileAssertion = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]");

    /**Metodo para comparar el nombre que se encuentra en el campo*/
    public void typeName(String name){
        driver.findElement(this.name).clear();
        driver.findElement(this.name).sendKeys(name);
    }

    /**Metodo para comparar el lastName que se encuentra en el campo*/
    public void typeLastName(String lastName){
        driver.findElement(this.lastName).clear();
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void clickGenderMale(){
        driver.findElement(genderMale).click();
    }

    public void clickGenderFemale(){
        driver.findElement(genderFamale).click();
    }

    public void clickGenderOther(){
        driver.findElement(genderOther).click();
    }

    public void typeNumber(String mobile){
        driver.findElement(this.mobile).clear();
        driver.findElement(this.mobile).sendKeys(mobile);
    }

    public void doSubmit(){
        driver.findElement(this.submit).submit();
    }

    public List<String> IsRegistrationDone() {
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(driver.findElement(studentNameAssertion).getText().trim());
        submitedFormResult.add(driver.findElement(genderAssertion).getText().trim());
        submitedFormResult.add(driver.findElement(mobileAssertion).getText().trim());
        return submitedFormResult;
    }


}
