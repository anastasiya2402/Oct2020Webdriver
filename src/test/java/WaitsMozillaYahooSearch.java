import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsMozillaYahooSearch {
    WebDriver driver;
    //1. Open Mozilla Browser
    //2. Open Yahoo
    //3. Type Query
    //4. Submit Query
    // 5. Wait for stats using explicit waits
    //6. Verify that stats are displayed
    //7. Verify the results page


    @Test
    public void testName() {

        openMozilla();
        openYahoo();
        typeQuery();
        submitQuery();
        waitForStats(By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div/ol[2]/li/div/div/span"));
        boolean verifyStats = isStatsDisplayed();
        Assert.assertTrue(verifyStats);
        verifyResultsPage();



    }

    private void verifyResultsPage() {
        WebElement element= driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div/ol[2]/li/div/div/span"));
        String text = element.getText();
        String[] arrayOfStrings=text.split(" ");
        String firstElementOfArray = arrayOfStrings[0].replace(",", "");
        int firstElement=Integer.parseInt(firstElementOfArray);
        boolean isElementLarge = firstElement > 170000000;
        Assert.assertTrue(isElementLarge);
        System.out.println(firstElement);

    }

    private void waitForStats(By xPath) {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xPath));
    }

    private boolean isStatsDisplayed() {
        String xPath="/html/body/div[1]/div[3]/div/div/div[1]/div/ol[2]/li/div/div/span";
        WebElement element= driver.findElement(By.xpath(xPath));
        return element.isDisplayed();
    }

    private void submitQuery() {
        WebElement element= driver.findElement(By.cssSelector("#ybar-sbq"));
        element.submit();
    }

    private void typeQuery() {
        String selector="#ybar-sbq";
        WebElement element= driver.findElement(By.cssSelector(selector));
        element.sendKeys("Portnov Computer School");
    }

    private void openYahoo() {
        driver.get("https://www.yahoo.com/");
    }

    private void openMozilla() {
        System.setProperty("webdriver.gecko.driver","src/test/resources/driver/macOs/geckodriver");
        driver=new FirefoxDriver();
    }
}
