package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;


public class OffersPageStepDefinition {


    public String offerPageProductName;
    TestContextSetup testContextSetup;

    public OffersPageStepDefinition(TestContextSetup setup) {
        this.testContextSetup = setup;
    }

    @Then("User searched for {string} shortname in offers page to check if product exists")
    public void userSearchedForTheSameShortnameInOffersPageToCheckIfProductExists(String shortName) throws InterruptedException {
        switchToOffersPage();

        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);
        Thread.sleep(2000);

        offerPageProductName = offersPage.getSearchResultAsText();
    }

    @And("Validate product name in offers page matches with landing page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(offerPageProductName,
                testContextSetup.landingPageProductName);
    }

    private void switchToOffersPage() {

        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.SwitchToChildWindow();

    }
}
