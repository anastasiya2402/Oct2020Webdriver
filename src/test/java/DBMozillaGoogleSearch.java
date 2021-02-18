import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DBMozillaGoogleSearch extends BaseTest {

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

    @Parameters({"queryParamKey"})
    @Test
    public void testSearchWithParameters(@Optional("Portnov Computer School") String queryParameter) {
        pom.mainPage.open();
        pom.mainPage.typeQuery(queryParameter);
        pom.mainPage.submitQuery();


        boolean statsDisplayed = pom.resultsPage.isStatsDisplayed();
        Assert.assertTrue(statsDisplayed);
        pom.resultsPage.verifySearchResults();
    }

    @DataProvider(name = "dataForGoogleSearch")
    public Object[][] createData1() {
        //TODO: read an external Excel file and use its data for data driven test scenario
        return new Object[][]{
                {"Portnov Computer School"},
                {"Portnov Computer School online"},
                {"123ffffddfrefrdfg"}
        };
    }

    @Test(dataProvider = "dataForGoogleSearch")
    public void testSearchWithDataProvider(String queryParameter) {

        pom.mainPage.open();
        pom.mainPage.typeQuery(queryParameter);
        pom.mainPage.submitQuery();


        // boolean statsDisplayed = pom.resultsPage.isStatsDisplayed();
        //  Assert.assertTrue(statsDisplayed);
        //   pom.resultsPage.verifySearchResults();
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
}
