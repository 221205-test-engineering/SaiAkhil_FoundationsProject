package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class testCaseViewPage {

    public WebDriver driver;

    public testCaseViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/button")
    public WebElement tEdit;

    @FindBy(xpath = "//html/body/div/fieldset[1]/textarea[1]")
    public WebElement descriptionBox;

    @FindBy(xpath = "/html/body/div/fieldset[1]/textarea[2]")
    public WebElement stepsBox;

    @FindBy(xpath = "/html/body/div/fieldset[1]/input")
    public WebElement checkbox;

    @FindBy(xpath = "/html/body/div/fieldset[1]/select")
    public WebElement performBy;

    @FindBy(xpath = "/html/body/div/fieldset[2]/select")
    public WebElement testResult;

    @FindBy(xpath = "/html/body/div/fieldset[2]/textarea")
    public WebElement summary;

    @FindBy(xpath = "/html/body/div/button[2]")
    public WebElement save;

    @FindBy(xpath = "/html/body/div/button[1]")
    public WebElement reset;


}
