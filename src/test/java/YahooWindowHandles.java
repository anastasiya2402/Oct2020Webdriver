import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class YahooWindowHandles {
    private WebDriver driver;

    @BeforeSuite
    public void setUpBeforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/macOs/geckodriver");
        driver = new FirefoxDriver();

    }


    @AfterSuite
    public void setUpAfterSuite() {
        driver.quit();
    }
    //1. Open Yahoo search
    //2. Type Portnov Computer School
    //3. Submit
    //4. Waiting for visibility of the link "portnov computer school online"
    //5. Openning link "portnov computer school online" in new tab and ending up
    // in the new window
    //6. Waiting for 2 windows.
    //7. Verifying that we are switched to new window with tab:"portnov computer school
    // online - Yahoo Search Results"
    //8. Verifying title of Switched Window and text

    @Test
    public void openTwoWindows() {

        navigateToYahoo();
        typeQuery();//Portnov Computer School
        submitQuery();
        waitForVisibility(By.linkText("portnov computer school online"));
        openLinkInNewTab(); //portnov computer school online: two windows
        waitForNumberOfWindows(2);
        int number = verifyAmountOfWindows();//2 windows:Portnov Computer School&portnov computer school online
        Assert.assertTrue(number == 2);
        boolean isSwitched = verifySwitchToWindow("portnov computer school online - Yahoo Search Results");
        Assert.assertEquals(isSwitched, true);
        verifyTitle("portnov computer school online - Yahoo Search Results");
        verifyPageSource("portnov computer school online");
    }

    private void verifyPageSource(String textToBeVerified) {
        String pageSource = driver.getPageSource();
        boolean text = pageSource.contains(textToBeVerified);
        Assert.assertEquals(text, true);

    }

    private void verifyTitle(String expectedTitle) {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, expectedTitle);
    }

    private void waitForNumberOfWindows(int numberOfWindows) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(driver -> driver.getWindowHandles().size() == numberOfWindows);
    }

    private boolean verifySwitchToWindow(String windowTitle) {
        boolean result = false;
        Set<String> windowHandles = driver.getWindowHandles();
        for (String eachHandle : windowHandles) {
            driver.switchTo().window(eachHandle);
            if (driver.getTitle().equalsIgnoreCase(windowTitle)) {
                result = true;
            }
        }
        return result;
    }

    private int verifyAmountOfWindows() {
        Set<String> windowHandles = driver.getWindowHandles();
        int numberOfWindows = windowHandles.size();
        return numberOfWindows;

    }

    private void waitForVisibility(By link) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(link));
    }

    private void openLinkInNewTab() {
        String link = "portnov computer school online";
        WebElement element = driver.findElement(By.linkText(link));
        new Actions(driver).keyDown(Keys.COMMAND).click(element).keyUp(Keys.COMMAND).build().perform();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    private void submitQuery() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]"));
        element.submit();
    }

    private void typeQuery() {
        String xPath = "//*[@id=\"ybar-sbq\"]";
        WebElement element = driver.findElement(By.xpath(xPath));
        element.sendKeys("Portnov Computer School");
    }

    private void navigateToYahoo() {
        driver.get("https://www.yahoo.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
