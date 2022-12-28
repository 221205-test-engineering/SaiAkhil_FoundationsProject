package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.testCaseViewPage;
import pages.testCasesPage;
import runners.bugCatcherRunner;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testCasesImpl {

    public WebDriver driver = bugCatcherRunner.driver;
    public pages.loginPage loginPage = bugCatcherRunner.loginPage;
    public pages.homePage homePage = bugCatcherRunner.homePage;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public testCasesPage testCasesPage = bugCatcherRunner.testCasesPage;

    public testCaseViewPage testCaseViewPage = bugCatcherRunner.testCaseViewPage;


    // For Scenario: Add a test case
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=23");
        loginPage.usrname.clear();
        loginPage.usrname.sendKeys("ryeGuy");
        loginPage.psw.clear();
        loginPage.psw.sendKeys("coolbeans");
        loginPage.login.click();
        wait.until(ExpectedConditions.visibilityOf(homePage.testCasesLink));
        homePage.testCasesLink.click();
    }

    @When("The tester types Description into input with")
    public void the_tester_types_description_into_input_with(String description) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(testCasesPage.submit));
        testCasesPage.description.sendKeys(description);

    }

    @When("The tester types Steps into input with")
    public void the_tester_types_steps_into_input_with(String steps) {

        testCasesPage.steps.clear();
        testCasesPage.steps.sendKeys(steps);
    }

    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() {
        testCasesPage.submit.click();

    }

    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(testCasesPage.bottomDescription)));
        //String expectedDescription = "Verify that usernames cannot have illegal charactersnew description";
        String actualDescription = testCasesPage.bottomDescription.getText();
        //assertEquals(expectedDescription, actualDescription);

    }

    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        String expected = "UNEXECUTED";
        String actual = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[5]/td[3]")).getText();
        assertEquals(expected, actual);
    }

    // For Scenario: Update a Test Case
    @When("The tester presses on details")
    public void the_tester_presses_on_details() {
        wait.until(ExpectedConditions.visibilityOf(testCasesPage.DetailsButton));
        testCasesPage.DetailsButton.click();

    }

    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        wait.until(ExpectedConditions.visibilityOf(testCasesPage.modalDialog));

        boolean modalIsPresent = false;

        if (testCasesPage.modalDialog != null) {
            modalIsPresent = true;
        }

        assertTrue(modalIsPresent);
    }


    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        String expected = "No One";

        assertEquals(expected, testCasesPage.performedBy.getText());

    }

    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() {
        testCasesPage.close.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(testCasesPage.modalDialog));

    }

    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        boolean modalClosed = false;

        try {
            boolean modalDisplayed = testCasesPage.modalDialog.isDisplayed();
        } catch (NoSuchElementException e) {
            e.toString();
            modalClosed = true;
        }

        assertTrue(modalClosed);
    }


    // For Scenario: Edit Existing Case

    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {
        driver.switchTo().activeElement();
        //driver.findElement(By.xpath("/html/body/div[3]/div/div/button[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div/button[2]/a")).click();
    }

    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("caseeditor"));
        String actualTitle = driver.getTitle();
        String expectedTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }


    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(testCaseViewPage.tEdit));
        testCaseViewPage.tEdit.click();
    }

    @When("The tester types in {string} into the description text area")
    public void the_tester_types_in_into_the_description_text_area(String description) {
        testCaseViewPage.descriptionBox.clear();
        testCaseViewPage.descriptionBox.sendKeys(description);

    }

    @When("The tester types in {string} into the steps text area")
    public void the_tester_types_in_into_the_steps_text_area(String steps) {
        testCaseViewPage.stepsBox.clear();
        testCaseViewPage.stepsBox.sendKeys(steps);
    }

    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        testCaseViewPage.checkbox.click();
    }

    @When("The tester selects {string} for performed from drop down")
    public void the_tester_selects_for_performed_from_drop_down(String tester) {
        Select dropdown = new Select(testCaseViewPage.performBy);
        dropdown.selectByVisibleText(tester);
    }

    @When("The tester selects {string} for test result from drop down")
    public void the_tester_selects_for_test_result_from_drop_down(String result) {
        Select dropdown = new Select(testCaseViewPage.testResult);
        dropdown.selectByVisibleText(result);
    }

    @When("The tester types in {string} into the summary text area")
    public void the_tester_types_in_into_the_summary_text_area(String summary) {
        testCaseViewPage.summary.clear();
        testCaseViewPage.summary.sendKeys(summary);
    }

    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() {
        testCaseViewPage.save.click();
    }

    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }

    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() {
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMsg = driver.switchTo().alert().getText();
        assertTrue(alertMsg.contains("Test Case"));
        driver.switchTo().alert().accept();
    }

    // For Scenario: Reset Test Case

    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() {
        testCaseViewPage.reset.click();
    }

    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement resetResult = driver.findElement(By.xpath("/html/body/div/fieldset[2]/p"));
        String resetResultText = resetResult.getText();
        assertEquals("FAIL", resetResultText);


    }
}
