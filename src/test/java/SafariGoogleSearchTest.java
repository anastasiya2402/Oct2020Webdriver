import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SafariGoogleSearchTest {
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
        submitQuery();
        waitFor(8);
        boolean verifyStats = isStatsDisplayed();
        Assert.assertTrue(verifyStats);
        verifySearchResults();
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

    private void waitFor(int amountOfpointSeconds) {
        try {
            Thread.sleep(8 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
