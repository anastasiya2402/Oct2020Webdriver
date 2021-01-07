import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class MozillaGoogleSearchTest {
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
        typeQuery();
    }

    private void typeQuery() {
        String selector=".gLFyf";
        String xpathValue="/html/body/div[2]/div[2]/form/div[2]/div[1]/div[1]/div/div[2]/input";
       // String tagName="input";    (does not work)
        String name="q";
     
       // WebElement element = driver.findElement(By.cssSelector(selector));
      // WebElement element = driver.findElement(By.xpath(xpathValue));
      //  WebElement element = driver.findElement(By.name(name));
        element.sendKeys( "Portnov Computer School");



    }

    private void navigateToMainPage() {
        driver.get("https://www.google.com/");
    }

    private void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/macOs/geckodriver");
        driver=new FirefoxDriver();
    }
}
