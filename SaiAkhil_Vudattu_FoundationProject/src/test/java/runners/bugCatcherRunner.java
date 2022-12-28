package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "steps")
public class bugCatcherRunner {
        public static WebDriver driver;
        public static loginPage loginPage;
        public static homePage homePage;
        public static pages.matrixPage matrixPage;
        public static testCasesPage testCasesPage;
        public static testCaseViewPage testCaseViewPage;
        public static defectsPage defectPage;



    @BeforeClass
        public static void set() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            loginPage = new loginPage(driver);
            homePage = new homePage(driver);
            matrixPage = new matrixPage(driver);
            testCasesPage = new testCasesPage(driver);
            testCaseViewPage = new testCaseViewPage(driver);
            defectPage = new defectsPage(driver);

        }

        @AfterClass
        public static void teardown(){
            driver.quit();
        }
    }

