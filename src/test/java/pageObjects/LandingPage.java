package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private final By search = By.xpath("//input[@type='search']");
    private final By productName = By.cssSelector("h4.product-name");
    private final By incrementButton = By.cssSelector("a.increment");
    private final By addToCartButton = By.cssSelector(".product-action button");
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String name) {
        driver.findElement(search).sendKeys(name);
    }


    public String getPageTitle() {
        return driver.getTitle();
    }
    public String getSearchResultAsText() {
        return driver.findElement(productName).getText();
    }

    public void selectTopDealsPage() {
        driver.findElement(By.linkText("Top Deals")).click();
    }

    public void clickIncrementButton(int incrementTimes) {
        while (incrementTimes > 0) {
            driver.findElement(incrementButton).click();
            incrementTimes--;
        }
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }
}
