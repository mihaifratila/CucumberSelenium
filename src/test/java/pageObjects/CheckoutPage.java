package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    By cartBag = By.cssSelector("[alt='Cart']");
    By checkoutButton = By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]");

    private final By productName = By.cssSelector("tr td:nth-child(1)");
    By applyPromoButton = By.cssSelector(".promoBtn");
    By placeOrderButton = By.xpath("//button[contains(text(), 'Place Order')]");

    public void CheckoutItems() {
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }

    public Boolean verifyPromoButton() {
        return driver.findElement(applyPromoButton).isDisplayed();
    }

    public Boolean verifyPlaceOrderButton() {
        return driver.findElement(placeOrderButton).isDisplayed();
    }

    public String getProductNameAsText() {
        return driver.findElement(productName).getText();
    }
}


