package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features"},
glue = {"StepDefinations"},
//tags = "@progression",
plugin = {"pretty","html:target/HtmlReport.html"}
		)
public class TestRunnerLogin extends AbstractTestNGCucumberTests{

}
