package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class defectsPage {

    public WebDriver driver;

    public defectsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/form/input[1]")
    public WebElement datePick;

    @FindBy(xpath = "/html/body/div[1]/form/textarea[1]")
    public WebElement description;

    @FindBy(xpath = "/html/body/div[1]/form/textarea[2]")
    public WebElement reproduceStep;

    @FindBy(xpath = "/html/body/div[1]/form/input[2]")
    public WebElement severity;

    @FindBy(xpath = "/html/body/div[1]/form/input[3]")
    public WebElement priority;

    @FindBy(xpath = "/html/body/div[1]/form/button")
    public WebElement defectReportBtn;

    @FindBy(xpath = "/html/body/div[3]/div/div")
    public WebElement defectModal;

    @FindBy(xpath = "/html/body/div[3]/div/div/h4")
    public WebElement defectCreatedMsg;

    @FindBy(xpath = "/html/body/div[3]/div/div/button")
    public WebElement closeBtn;

    @FindBy(xpath = "/html/body/div[1]/h1")
    public WebElement reportDefectTitle;






}
