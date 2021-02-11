package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage {


    private static final String MAIN_PAGE_URL = "https://www.google.com/";
    private static By queryName = By.name("q");
    private final WebDriver driver;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(MAIN_PAGE_URL);
    }

    public void typeQuery(String query) {
        WebElement element = driver.findElement(queryName);
        element.sendKeys(query);
    }

    public void submitQuery() {
        WebElement element = driver.findElement(queryName);
        element.submit();
    }

}
