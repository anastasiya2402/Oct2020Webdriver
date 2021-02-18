package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Common;

public class GoogleResultsPage {


    private static By resultsStats = By.id("result-stats");
    private final WebDriver driver;

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isStatsDisplayed() {
        Common.waitForElement(driver, resultsStats);
        WebElement resultsElement = driver.findElement(resultsStats);
        return resultsElement.isDisplayed();
    }

    //TODO: inplement this method
    public boolean noStatsDisplayed() {
        boolean notDisplayed = false;
        try {
            Common.waitForElement(driver, resultsStats);
            WebElement resultsElement = driver.findElement(resultsStats);
        } catch (Exception e) {
            System.out.println("Stats are not displayed");
            notDisplayed = true;
        }
        return notDisplayed;

    }

    public void verifySearchResults() {
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

}
