package steps.matrix;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.loginPage;
import pages.matrixPage;
import runners.bugCatcherRunner;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class matrixImpl {

        public WebDriver driver = bugCatcherRunner.driver;
        public loginPage loginPage = bugCatcherRunner.loginPage;
        public pages.homePage homePage = bugCatcherRunner.homePage;
        public matrixPage matrixPage = bugCatcherRunner.matrixPage;

        public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    // For Scenario: Create a New Matrix

        @Given("The manager is logged in as a manager")
        public void the_manager_is_logged_in_as_a_manager() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=23");
        loginPage.usrname.sendKeys("g8tor");
        loginPage.psw.sendKeys("chomp!");
        loginPage.login.click();
         }
         @Given("The manager is on the home page")
        public void the_manager_is_on_the_home_page() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(homePage.welcomeMsg));
            String managerHomeTitle = driver.getTitle();
            System.out.println("Manager is now on :" + managerHomeTitle);
        }
        @When("The manager chooses to create a new matrix")
        public void the_manager_chooses_to_create_a_new_matrix() {
            homePage.newMatrix.click();
        }

        @When("The manager creates a title for the matrix")
        public void the_manager_creates_a_title_for_the_matrix() {
            homePage.matrixTitle.sendKeys("Test Title");
        }

        @When("The manager adds requirements to the matrix")
        public void the_manager_adds_requirements_to_the_matrix() {
            homePage.userStory.sendKeys("Test Rule");
            homePage.addRequirement.click();
        }

        @When("The manager saves the matrix")
        public void the_manager_saves_the_matrix() {
            homePage.createMatrix.click();
        }

        @Then("An alert with a success message should appear")
        public void an_alert_with_a_success_message_should_appear() {
            wait.until(ExpectedConditions.alertIsPresent());

            String alertMsg = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            assertTrue(alertMsg.contains("Matrix with ID "));
        }

        // For scenario: Update defects

    }
