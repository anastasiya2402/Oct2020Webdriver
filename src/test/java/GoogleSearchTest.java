import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    WebDriver driver;

    //1. Open the browser.
    //2. Navigate to the main Google page.
    //3. Type the query.
    //4. Submit the query.
    //5. Verify the results page.
    @Test
    public void testName() {

        openBrowser();
        navigateToMainPage();
        //typeQuery();
    }

    private void navigateToMainPage() {
        driver.get("https://www.google.com/");
    }

    private void openBrowser() {

      driver=new SafariDriver();
    }
}
