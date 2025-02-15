package StepDefinations;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import Pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinations {

	static WebDriver driver;
	loginPage login;
	
	@Given("user is on login page.")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
		try {
			EdgeOptions options = new EdgeOptions();
			options.setCapability("webSocketUrl", true);
			driver = new EdgeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.get("https://www.saucedemo.com/v1/");
		} catch (Exception e) {
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("webSocketUrl", true);
			driver = new FirefoxDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.get("https://www.saucedemo.com/v1/");
		}		
	}

	@When("user enters valid {string} and {string}.")
	public void user_enters_valid_and(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
	    
		login = new loginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		
	}

	@And("user clicks on login button.")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
		login.clickOnLoginButton();
	}

	@Then("user is navigated to home page.")
	public void user_is_navigated_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions

		Assert.assertEquals(login.homePageElement(), true);
		
	}

	@Then("user is not navigated to home page.")
	public void user_is_not_navigated_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
		System.out.println("Error while logging in.");
	}

	@Then("user gets error.")
	public void user_gets_error() {
	    // Write code here that turns the phrase above into concrete actions
	    
		Assert.assertEquals(login.lockOutError(),"Epic sadface: Sorry, this user has been locked out.");
		
	}
	
	@And("close the browser.")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    
		driver.quit();
	}
}
