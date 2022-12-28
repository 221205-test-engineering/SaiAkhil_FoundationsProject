package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    public WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/fieldset/input[1]")
    public WebElement usrname;

    @FindBy(xpath = "/html/body/div/fieldset/input[2]")
    public WebElement psw;

    @FindBy(xpath = "/html/body/div/fieldset/button")
    public WebElement login;
}
