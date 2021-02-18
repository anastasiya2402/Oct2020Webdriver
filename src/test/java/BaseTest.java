import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.Google;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public Google pom;
    public WebDriver driver;

    @Parameters({"browser"})
    @BeforeSuite
    public void beforeSuite(@Optional String browser) {
        //TODO: add more code to run your tests in different browsers
        //   if(browser.contains("Firefox")){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/macOs/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //     }
        pom = new Google(driver);
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }


}
