import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsMozillaGoogleSearch {
    WebDriver driver;

    //1. Open the browser.
    //2. Navigate to the main Google page.
    //3. Type the query.
    //4. Submit the query.
    //5. Wait using explicit waits.
    //6. Verify the results page.

    @Test
    public void testName() {

        openBrowser();
        navigateToMainPage();
        typeQuery();
        submitQuery();
        waitForElement(By.id("result-stats"));
        boolean statsDisplayed = isStatsDisplayed();
        Assert.assertTrue(statsDisplayed);
        verifySearchResults();

    }

    private void waitForElement(By elementById) {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementById));

    }


    private void verifySearchResults() {
        WebElement resultsElement = driver.findElement(By.id("result-stats"));
        String text = resultsElement.getText();
        String[] arrayOfStrings = text.split(" ");
        String secondElement = arrayOfStrings[1];
        secondElement = secondElement.replace(",", "");
        int number = Integer.parseInt(secondElement);
        boolean isLargeNumber = number > 100000;
        Assert.assertTrue(isLargeNumber);
        System.out.println(number);

    }


    private boolean isStatsDisplayed() {
        WebElement resultsElement = driver.findElement(By.id("result-stats"));
        return resultsElement.isDisplayed();
    }

    private void submitQuery() {
        String name = "q";
        WebElement element = driver.findElement(By.name(name));
        element.submit();

    }

    private void typeQuery() {
        String selector = ".gLFyf";
        String xpathValue = "/html/body/div[2]/div[2]/form/div[2]/div[1]/div[1]/div/div[2]/input";
        // String tagName="input";    (does not work)
        String name = "q";

        // WebElement element = driver.findElement(By.cssSelector(selector));
        // WebElement element = driver.findElement(By.xpath(xpathValue));
        WebElement element = driver.findElement(By.name(name));
        element.sendKeys("Portnov Computer School");


    }

    private void navigateToMainPage() {
        driver.get("https://www.google.com/");
    }

    private void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/macOs/geckodriver");
        driver = new FirefoxDriver();
    }
}
