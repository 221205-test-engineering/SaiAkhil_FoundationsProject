package steps.matrix;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.loginPage;
import pages.matrixPage;
import runners.bugCatcherRunner;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class matrixUpdate {
    public WebDriver driver = bugCatcherRunner.driver;
    public pages.loginPage loginPage = bugCatcherRunner.loginPage;
    public pages.homePage homePage = bugCatcherRunner.homePage;
    public pages.matrixPage matrixPage = bugCatcherRunner.matrixPage;

    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Given("The manager is on the matrix homepage")
    public void the_manager_is_on_the_matrix_homepage() {
        homePage.matrixLink.click();
        assertEquals("Matrix Dashboard", driver.getTitle());
    }

    @Given("The manager has selected the matrix")
    public void the_manager_has_selected_the_matrix() {
        homePage.matrixLink.click();
        driver.navigate().to("https://bugcatcher-dan.coe.revaturelabs.com/matrices");
        WebElement matrixShowBtn = driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/span/button"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/ul/li[1]/div/span/button")));
        matrixShowBtn.click();

    }

    @When("The manager adds a defect")
    public void the_manager_adds_a_defect() {
        wait.until(ExpectedConditions.visibilityOf(matrixPage.editAirlineBtn));
        matrixPage.editAirlineBtn.click();
        matrixPage.defectArea.sendKeys("901");
        matrixPage.addDefect.click();
    }

    @When("The manager confirms their changes")
    public void the_manager_confirms_their_changes() {
        matrixPage.save.click();
    }

    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
        wait.until(ExpectedConditions.alertIsPresent());
        String actualAlert = driver.switchTo().alert().getText();
        assertEquals("Matrix Saved", actualAlert);
        driver.switchTo().alert().accept();
    }


    // For scenario: Update test cases
    @When("The manager adds a Test Cases")
    public void the_manager_adds_a_test_cases() {
        wait.until(ExpectedConditions.visibilityOf(matrixPage.editAirlineBtn));
        matrixPage.editAirlineBtn.click();
        matrixPage.testCaseArea.sendKeys("801");
        matrixPage.addTestCase.click();
    }


}
