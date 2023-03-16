package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    private final By search = By.xpath("//input[@type='search']");
    private final By productName = By.cssSelector("tr td:nth-child(1)");
    public WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String name) {
        driver.findElement(search).sendKeys(name);
    }

    public String getSearchResultAsText() {
        return driver.findElement(productName).getText();
    }
}
