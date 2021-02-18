import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MozillaYahooSearch {
  public WebDriver driver;
    //1. Open Mozilla Browser
    //2. Open Yahoo
    //3. Type Query
    //4. Submit Query
    // 5. Wait for 8 seconds
    //6. Verify Results Page by verifying that page has "portnov computer school online" link
    //7. Click on the link "portnov computer school online" just to see that it works.


    @Test
    public void testName() {
        openMozilla();
        goToYahoo();
        typeQuery();
        submitQuery();
        waitFor(8);
        verifyPageResults();
        submitLink();
    }

    private void submitLink() {
        String link = "portnov computer school online class";
        WebElement element = driver.findElement(By.linkText(link));
        element.click();
    }

    private void waitFor(int numberOfPointSeconds) {
        try {
            Thread.sleep(8*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void verifyPageResults() {
        String selector = "a.ac-1st";
        WebElement element = driver.findElement(By.cssSelector(selector));
        String text=element.getText();
        Assert.assertEquals(text, "portnov computer school online class");
        System.out.println(text);
    }

    private void submitQuery() {
        String selector="#ybar-sbq";
        WebElement element= driver.findElement(By.cssSelector(selector));
        element.submit();
    }

    private void typeQuery() {
        String selector="#ybar-sbq";
        WebElement element=driver.findElement(By.cssSelector(selector));
        element.sendKeys("Portnov Computer School");
    }

    private void openMozilla() {
        System.setProperty("webdriver.gecko.driver","src/test/resources/driver/macOs/geckodriver");
        driver=new FirefoxDriver();
    }

    private void goToYahoo() {
       driver.get("https://www.yahoo.com");
    }
}
