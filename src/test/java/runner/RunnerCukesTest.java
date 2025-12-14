package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = {"src/test/resources/features/test1.feature"},
                glue = {"steps", "screens"},
                plugin = {"pretty",
                        "html:target/cucumber-report-TestNG/{platformName}/TestResults.html",
                        //"junit:target/cucumber-report-TestNG/android/cucumber.xml",
                        //"json:target/cucumber-report-TestNG/android/cucumber.json"
                }
        )
public class RunnerCukesTest extends BaseTest {
}