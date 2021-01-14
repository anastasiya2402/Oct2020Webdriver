import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SafariYouTubeSearch {
WebDriver driver;


    @Test
    public void testName() {
        //1. Open Safari Browser
        //2. Open YouTube
        //3. Type Query
        //4. Submit Query
        //5. Wait for few seconds
        //6. Verify the Query by the file in Search
        openBrowser();
        openYouTube();
        typeQuery();
        submitQuery();
        waitFor(8);
        verifyQuery();



    }

    private void waitFor(int amountOfSeconds) {
        try {
            Thread.sleep(8*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void verifyQuery() {
        String xpath="//*[@id=\"video-title\"]/yt-formatted-string";
        WebElement video=driver.findElement(By.xpath(xpath));
        String text= video.getText();
        System.out.println(text);
    }

    private void submitQuery() {
        String xpath="//*[@id=\"search-icon-legacy\"]/yt-icon";
        WebElement element= driver.findElement(By.xpath(xpath));
        element.click();
    }

    private void typeQuery() {
        String xpath="//*[@id=\"search\"]";
        WebElement element= driver.findElement(By.xpath(xpath));
        element.sendKeys("Selenium 1 with Ellie");
    }


    private void openYouTube() {
        driver.get("https://www.youtube.com/");
    }

    private void openBrowser() {
        driver=new SafariDriver();
    }
}
