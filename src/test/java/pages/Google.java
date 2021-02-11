package pages;

import org.openqa.selenium.WebDriver;

public class Google {

    public GoogleMainPage mainPage;
    public GoogleResultsPage resultsPage;

    public Google(WebDriver driver) {

        mainPage = new GoogleMainPage(driver);
        resultsPage = new GoogleResultsPage(driver);

    }
}
