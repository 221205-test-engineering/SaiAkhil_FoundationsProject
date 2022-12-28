package steps.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.bugCatcherRunner;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class loginPositiveImpl {


    public WebDriver driver = bugCatcherRunner.driver;

    public pages.loginPage loginPage = bugCatcherRunner.loginPage;
    public pages.homePage homePage = bugCatcherRunner.homePage;

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=23");

    }

    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String username) {
       // loginPage.usrname.clear();
        loginPage.usrname.sendKeys(username);
    }

    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String password) {
       // loginPage.psw.clear();
        loginPage.psw.sendKeys(password);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        loginPage.login.click();
    }

    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_role_page (String role) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.welcomeMsg));
        String actualTitle = driver.getTitle();
        assertEquals(role+" Home", actualTitle);

    }

    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_fname_lname_on_the_home_page (String fname, String lname) {
        assertEquals("Welcome "+ fname+" "+ lname, homePage.welcomeMsg.getText());
    }

}
