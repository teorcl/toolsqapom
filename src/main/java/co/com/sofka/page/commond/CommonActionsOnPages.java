package co.com.sofka.page.commond;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonActionsOnPages {
    private final WebDriver driver;

    public CommonActionsOnPages(WebDriver driver) {
        this.driver = driver;
    }

    protected void clear(By by){
        driver.findElement(by).clear();
    }

    protected void type(By by, String... value){
        driver.findElement(by).sendKeys(value);
    }

    protected void clickOn(By by){
        driver.findElement(by).click();
    }

    protected void doSubmit(By by){
        driver.findElement(by).submit();
    }

    protected String getText(By by){
        return driver.findElement(by).getText();
    }

}
