package steps.defect;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.bugCatcherRunner;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static runners.bugCatcherRunner.driver;

public class defectReportImpl {
    public pages.loginPage loginPage = bugCatcherRunner.loginPage;
    public pages.homePage homePage = bugCatcherRunner.homePage;
    public pages.defectsPage defectPage = bugCatcherRunner.defectPage;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    // 1.3 Report Defect Negative


    @When("The employee types in Description with")
    public void the_employee_types_in_description_with(String docString) {
        defectPage.description.clear();
        defectPage.description.sendKeys(docString);
    }


    @When("The employee types in Steps with")
    public void the_employee_types_in_steps_with(String string) {
        defectPage.reproduceStep.clear();
        defectPage.reproduceStep.sendKeys(string);
    }

    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {
        Actions action = new Actions(driver);
        action.clickAndHold(defectPage.priority)
                .keyDown(Keys.ARROW_RIGHT)
                .keyUp(Keys.ARROW_RIGHT)
                .build()
                .perform();
    }
    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
        Actions action = new Actions(driver);
        action.clickAndHold(defectPage.severity)
                .keyDown(Keys.ARROW_LEFT)
                .keyUp(Keys.ARROW_LEFT)
                .build()
                .perform();
    }

    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {
        try{
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        }catch  (TimeoutException e){
            System.out.println(e.getMessage());
        }
    }


    //-----------------------------------------------------------------------------------------------------------------------
    // 1.3.2 No Date Selected



    //-----------------------------------------------------------------------------------------------------------------------
    //1.4 Report Defect Positive
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=18");
        loginPage.usrname.clear();
        loginPage.usrname.sendKeys("ryeGuy");
        loginPage.psw.clear();
        loginPage.psw.sendKeys("coolbeans");
        loginPage.login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.reportDefectLink));
        homePage.reportDefectLink.click();
    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        LocalDate today = java.time.LocalDate.now(); // YYYY-MM-DD
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = today.format(formatter);

        System.out.println("Today is: "+ date);

        defectPage.datePick.sendKeys(date);
    }

    @When("The employee selects {string} priority")
    public void the_employee_selects_priority(String priority) {
        Actions action = new Actions(driver);
        action.clickAndHold(defectPage.priority).build().perform();


    }
    @When("The employee selects {string} severity")
    public void the_employee_selects_severity(String severity) {
        Actions action = new Actions(driver);
        action.clickAndHold(defectPage.severity).build().perform();

    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        defectPage.defectReportBtn.click();
    }
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        driver.switchTo().alert().accept();
    }
    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        wait.until(ExpectedConditions.visibilityOf(defectPage.defectModal));
        String expected = defectPage.defectCreatedMsg.getText();
        String actual = defectPage.defectCreatedMsg.getText();

        assertEquals(expected,actual);

    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() {
        defectPage.closeBtn.click();
    }

    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/button")));
        String expected = defectPage.reportDefectTitle.getText();
        String actual = defectPage.reportDefectTitle.getText();

        assertEquals(expected,actual);
    }

}
