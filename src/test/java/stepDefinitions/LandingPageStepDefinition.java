package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.io.IOException;


public class LandingPageStepDefinition {

    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup setup) {
        this.testContextSetup = setup;
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User navigates to GreenCart Landing page")
    public void userNavigatesToGreenCartLandingPage() throws IOException {

        String landingPageTitle= landingPage.getPageTitle();

        Assert.assertTrue(landingPageTitle.contains("GreenKart"));
    }

    @When("User searched with the shortname {string} and extracted name of the product")
    public void userSearchedWithTheShortnameAndExtractedNameOfTheProduct(String shortName) throws InterruptedException {

        landingPage.searchItem(shortName);
        Thread.sleep(2000);

        testContextSetup.landingPageProductName = landingPage
                        .getSearchResultAsText()
                        .split("-")[0].trim();

    }


    @When("Added {string} items of the selected product to cart")
    public void addedItemsOfTheSelectedProductToCart(String incrementAmount) throws InterruptedException {

        landingPage.clickIncrementButton(Integer.parseInt(incrementAmount));
        landingPage.clickAddToCartButton();
    }

}
