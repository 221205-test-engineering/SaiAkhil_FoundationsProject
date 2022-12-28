package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class matrixPage {

    public WebDriver driver;

    public matrixPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="/html/body/div/ul/li[1]/div/span/button")
    public WebElement showAirlineBtn;

    @FindBy(xpath="/html/body/div/ul/li[1]/div/div/div/table/tbody/tr[1]/td[6]/button")
    public WebElement editAirlineBtn;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[1]/li[2]/input")
    public WebElement testCaseArea;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[1]/li[2]/button")
    public WebElement addTestCase;
    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[2]/li/input")
    public WebElement defectArea;

    @FindBy(xpath="/html/body/div/ul/li[1]/div/div/div/ul[2]/li/button")
    public WebElement addDefect;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/button")
    public WebElement save;
}

