package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {

        String localResourcesPath = System.getProperty("user.dir") + "/src/test/resources/";

        FileInputStream fis = new FileInputStream(localResourcesPath + "global.properties");
        Properties properties = new Properties();
        properties.load(fis);
        String url = properties.getProperty("QAUrl");

        if (driver == null) {
            if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", localResourcesPath + "chromedriver");
                driver = new ChromeDriver();
            }
            driver.get(url);
        }
        return driver;
    }
}
