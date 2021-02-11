import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.Google;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public Google pom;
    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/macOs/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        pom = new Google(driver);

    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }


}
