import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsSafariGoogleSearch {
    WebDriver driver;

    //1. Open the browser.
    //2. Navigate to the main Google page.
    //3. Type the query.
    //4. Submit the query.
    //5. Wait for element using explicit waits.
    //6. Verify the results page.
    @Test
    public void testName() {

        openBrowser();
        navigateToMainPage();
        typeQuery();
        submitQuery();
        waitForElement(By.id("result-stats"));
        boolean verifyStats = isStatsDisplayed();
        Assert.assertTrue(verifyStats);
        verifySearchResults();
    }

    private void waitForElement(By elementId) {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementId));


    }

    private void verifySearchResults() {
        WebElement element = driver.findElement(By.id("result-stats"));
        String text = element.getText();
        String[] arrayOfStrings = text.split(" ");
        String arrayOfStringsSecond = arrayOfStrings[1].replace(",", "");
        int SecondElement = Integer.parseInt(arrayOfStringsSecond);
        boolean isElementLarge = SecondElement > 100000;
        Assert.assertTrue(isElementLarge);

        System.out.println(SecondElement);
    }


    private boolean isStatsDisplayed() {
        String id = "result-stats";
        WebElement resultElement = driver.findElement(By.id(id));
        return resultElement.isDisplayed();

    }

    private void submitQuery() {
        String name = "q";
        WebElement element = driver.findElement(By.name(name));
        element.submit();
    }

    private void typeQuery() {
        String xPathValue = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input";
        String selector = ".gLFyf";
        String name = "q";
        String tagname = "input";
        WebElement element = driver.findElement(By.xpath(xPathValue));
        // WebElement element = driver.findElement(By.cssSelector(selector));
        // WebElement element=driver.findElement(By.name(name));
        // WebElement element=driver.findElement(By.tagName(tagname)); does not work
        element.sendKeys("Portnov Computer School");
    }

    private void navigateToMainPage() {
        driver.get("https://www.google.com/");
    }

    private void openBrowser() {

        driver = new SafariDriver();
    }
}
