import org.testng.Assert;
import org.testng.annotations.Test;


public class POMMozillaGoogleSearch extends BaseTest {


    //1. Open the browser.
    //2. Navigate to the main Google page.
    //3. Type the query.
    //4. Submit the query.
    //5. Verify the results page.

    @Test
    public void testPerformSearchVerifyResult() {
        String query = "Portnov Computer School";

        pom.mainPage.open();
        pom.mainPage.typeQuery(query);
        pom.mainPage.submitQuery();


        boolean statsDisplayed = pom.resultsPage.isStatsDisplayed();
        Assert.assertTrue(statsDisplayed);
        pom.resultsPage.verifySearchResults();
    }

    @Test
    public void testPerformWrongSearchVerifyError() {
        String query = "123dfdbfgnghn";
        pom.mainPage.open();
        pom.mainPage.typeQuery(query);
        pom.mainPage.submitQuery();
        boolean noStatsDisplayed = pom.resultsPage.noStatsDisplayed();
        Assert.assertTrue(noStatsDisplayed);


    }


    // private void waitFor(int amountOfSeconds) {
    //   try {
    //       Thread.sleep(8 * 100);
    //  } catch (InterruptedException e) {
    //      e.printStackTrace();
    //   }
    // }

}
