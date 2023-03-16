package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;



public class CheckoutPageStepDefinition {

    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup setup) {
        this.testContextSetup = setup;
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }


    @Then("User proceeds to Checkout and validate the {string} items in checkout page")
    public void userProceedsToCheckoutAndValidateTheItemsInCheckoutPage(String longName) throws InterruptedException {

        checkoutPage.CheckoutItems();
        Thread.sleep(2000);
    }

    @And("Verify user has the ability to enter promo codes and place an order")
    public void verifyUserHasTheAbilityToEnterPromoCodesAndPlaceAnOrder() {
        Assert.assertTrue(checkoutPage.verifyPromoButton());
        Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
    }
}

