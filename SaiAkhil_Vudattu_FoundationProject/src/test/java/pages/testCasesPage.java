package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class testCasesPage {
    public WebDriver driver;

    public testCasesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/form/fieldset/textarea[1]")
    public WebElement description;

    @FindBy(xpath = "/html/body/div[1]/form/fieldset/textarea[2]")
    public WebElement steps;

    @FindBy(xpath = "/html/body/div[1]/form/fieldset/button")
    public WebElement submit;

    @FindBy(xpath = "//tbody/tr[last()]/td[2]")
    public WebElement bottomDescription;

    @FindBy(xpath = "/html/body/div[1]/table/tbody/tr[5]/td[3]")
    public WebElement testResult;


    @FindBy(xpath = "//tbody/tr[last()]/td[4]")
    public WebElement DetailsButton;

    @FindBy(className = "ReactModal__Content")
    public WebElement modalDialog;

    @FindBy(xpath = "/html/body/div[3]/div/div/p[6]")
    public WebElement performedBy;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[1]")
    public WebElement close;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[2]")
    public WebElement edit;

}
