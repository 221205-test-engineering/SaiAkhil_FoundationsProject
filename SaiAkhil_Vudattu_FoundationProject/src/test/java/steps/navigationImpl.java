package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.homePage;
import pages.loginPage;
import runners.bugCatcherRunner;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class navigationImpl {

    public WebDriver driver = bugCatcherRunner.driver;
    public loginPage loginPage = bugCatcherRunner.loginPage;
    public homePage homePage = bugCatcherRunner.homePage;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    //Background
//    @Given("The manager is logged in as a manager")
//    public void the_manager_is_logged_in_as_a_manager() {
//        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=23");
//        loginPage.usrname.clear();
//        loginPage.usrname.sendKeys("g8tor");
//        loginPage.psw.clear();
//        loginPage.psw.sendKeys("chomp!");
//        loginPage.login.click();
//
//    }
//    @Given("The manager is on the home page")
//    public void the_manager_is_on_the_home_page() {
//        wait.until(ExpectedConditions.visibilityOf(homePage.welcomeMsg));
//        String managerHomeTitle = driver.getTitle();
//        System.out.println("Manager is now on :" + managerHomeTitle);
//    }

    // For Scenario: Homepage links visible
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {

        String matricesLink = homePage.matrixLink.getText();
        String testCaseLink = homePage.testCasesLink.getText();
        String reportDefectLink = homePage.reportDefectLink.getText();
        String defectOverviewLink = homePage.defectOverviewLink.getText();

        assertEquals("Matrices", matricesLink);
        assertEquals("Test Cases", testCaseLink);
        assertEquals("Report a Defect", reportDefectLink);
        assertEquals("Defect Overview", defectOverviewLink);

    }

    // For Scenario: Back Navigation
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        homePage.matrixLink.click();
    }
    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        String actualTitle = driver.getTitle();

        assertEquals("Matrix Dashboard", actualTitle);
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        driver.navigate().back();
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {
        String actualTitle = driver.getTitle();
        String expected = "Manager Home";
        assertEquals(expected, actualTitle);
    }
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        homePage.testCasesLink.click();;
    }


    // For Scenario: All links viable
    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String linkTxt) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/nav/a[6]")));
        WebElement links = driver.findElement(By.linkText(linkTxt));
        links.click();
    }
    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }


}
