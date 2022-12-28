package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

    public WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/nav/p")
    public WebElement welcomeMsg;

    @FindBy(xpath = "/html/body/div/nav/a[1]")
    public WebElement matrixLink;

    @FindBy(xpath = "/html/body/div/nav/a[2]")
    public WebElement testCasesLink;

    @FindBy(xpath = "/html/body/div/nav/a[3]")
    public WebElement reportDefectLink;

    @FindBy(xpath = "/html/body/div/nav/a[4]")
    public WebElement defectOverviewLink;

    @FindBy(xpath = "/html/body/div/nav/a[5]")
    public WebElement logout;

    @FindBy(xpath = "/html/body/div/button")
    public WebElement newMatrix;

    @FindBy(xpath = "/html/body/div/input")
    public WebElement matrixTitle;

    @FindBy(xpath = "/html/body/div/fieldset/table/tbody/tr/td[1]/input")
    public WebElement userStory;

    @FindBy(xpath = "/html/body/div/fieldset/button")
    public WebElement addRequirement;

    @FindBy(xpath = "/html/body/div/button")
    public WebElement createMatrix;

    @FindBy(xpath = "/html/body/div/h3")
    public WebElement defectList;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[3]/button")
    public WebElement selectDefectBtn;

    @FindBy(xpath = "/html/body/div/div/h4")
    public WebElement defectFont;

    @FindBy(xpath = "/html/body/div/div/button")
    public WebElement assign;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/div[1]/span/button")
    public WebElement changeStatus;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[1]")
    public WebElement accepted;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[2]")
    public WebElement rejected;
    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[3]")
    public WebElement fixed;
    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[4]")
    public WebElement declined;
    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[5]")
    public WebElement shelved;

}
