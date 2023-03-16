package cucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failed_scenarios.txt",
                 glue = "stepDefinitions",
                 plugin = {"pretty", "html:target/cucumber.html",
                           "json:target/cucumber.json",
                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",} )
public class TestNGFailedTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
