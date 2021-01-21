import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsMozillaBingSearch {
    WebDriver driver;

    @Test
    public void testName() {

        //1. Open Mozilla Browser
        //2. Open Bing
        //3. Type Query
        //4. Submit Query
        //5. Wait using explicit waits
        //6. Verify that the number of results displayed.
        //7. Verify Query by the number of results
        openBrowser();
        goToBing();
        typeQuery();
        submitQuery();
      waitForElement(By.xpath("/html/body/div[3]/main/div/span[1]"));
        boolean stats=isStatsDisplayed();
        Assert.assertTrue(stats);
        verifyQuery();


    }

    private void waitForElement(By elementXpath) {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementXpath));
    }

    private void verifyQuery() {
        WebElement result= driver.findElement(By.xpath("/html/body/div[3]/main/div/span[1]"));
        String stats=result.getText();
        String[] arrayOfStrings=stats.split(" ");
        String firstElement=arrayOfStrings[0].replace(",", "");
        int  element=Integer.parseInt(firstElement);
        boolean isNumberLarge=element>170000000;
        Assert.assertTrue(isNumberLarge);
        System.out.println(element);
    }


    private boolean isStatsDisplayed() {
        WebElement result= driver.findElement(By.xpath("/html/body/div[3]/main/div/span[1]"));
        return result.isDisplayed();
    }

    private void submitQuery() {
        String xpath="//*[@id=\"sb_form_q\"]";
        WebElement element= driver.findElement(By.xpath(xpath));
        element.submit();
    }

    private void typeQuery() {
        String xpath="//*[@id=\"sb_form_q\"]";
        WebElement element= driver.findElement(By.xpath(xpath));
        element.sendKeys("Portnov Computer School");
    }

    private void goToBing() {
        driver.get("https://www.bing.com/");

    }

    private void openBrowser() {
        System.setProperty("webdriver.gecko.driver","src/test/resources/driver/macOs/geckodriver");
        driver=new FirefoxDriver();
    }
}
