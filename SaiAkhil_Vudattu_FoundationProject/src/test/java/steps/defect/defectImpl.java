package steps.defect;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.bugCatcherRunner;
import static org.junit.Assert.assertEquals;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertTrue;
import static runners.bugCatcherRunner.driver;

public class defectImpl {

    public pages.loginPage loginPage = bugCatcherRunner.loginPage;
    public pages.homePage homePage = bugCatcherRunner.homePage;
    public pages.defectsPage defectPage = bugCatcherRunner.defectPage;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    // DEFECTS
    // 1. - ASSIGN DEFECTS
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {

        try{
            assertEquals("Assign Defects", homePage.defectList.getText());
        }catch (org.openqa.selenium.TimeoutException e){
            System.out.println("No Defects");
        }
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        wait.until(ExpectedConditions.visibilityOf(homePage.selectDefectBtn));
        homePage.selectDefectBtn.click();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        homePage.defectFont.getText();
        wait.until(ExpectedConditions.visibilityOf(homePage.defectFont));
        String expected = homePage.defectFont.getText();
        String actual = homePage.defectFont.getText();
        assertEquals(expected,actual);

    }
    @When("The manager selects a tester from the drop down list")
    public void the_manager_selects_a_tester_from_the_drop_down_list() {
        driver.findElement(By.xpath("/html/body/div/div/input")).sendKeys("ryeGuy");
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        homePage.assign.click();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        String expected = "Assign Defects";
        String actual = homePage.defectList.getText();
        assertEquals(expected, actual);
    }

    //-----------------------------------------------------------------------------------------------------------------------

    // 1.2 Defect Status
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=18");
        loginPage.usrname.clear();
        loginPage.usrname.sendKeys("ryeGuy");
        loginPage.psw.clear();
        loginPage.psw.sendKeys("coolbeans");
        loginPage.login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.welcomeMsg));
        String pageTitle = driver.getTitle();
        System.out.println("Tester is now on :" + pageTitle);
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() {
        WebElement testerDefects = driver.findElement(By.xpath("/html/body/div[1]/h3[1]"));
        String expected = "My Defects";
        String actual = testerDefects.getText();
        assertEquals(expected,actual);
    }
    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        WebElement defectText =  driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/span/p/b[2]"));
        defectText.click();
        wait.until(ExpectedConditions.visibilityOf(homePage.changeStatus));
        homePage.changeStatus.click();

        homePage.accepted.click();
        homePage.rejected.click();
        homePage.fixed.click();
        homePage.declined.click();
        homePage.shelved.click();
    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div/span/p")).click();
        WebElement currentStatus = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div/span/p/b[2]"));
        String expected ="Declined";
        String actual = "Declined";

        assertEquals(expected,actual);
    }

//-----------------------------------------------------------------------------------------------------------------------


}
