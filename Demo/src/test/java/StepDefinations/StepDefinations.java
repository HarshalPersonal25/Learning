package StepDefinations;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.loginPage;
import Pages.menuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinations {

	static WebDriver driver;
	loginPage login;
	menuPage menu;
	
	@Given("user is on login page.")
	public void user_is_on_login_page() {
	    
		try {
			driver = new EdgeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.get("https://www.saucedemo.com/v1/");
		} catch (Exception e) {
			driver = new FirefoxDriver();
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
	
	@When("user clicks on Menu button.")
	public void user_clicks_on_menu_button() {
	    menu = new menuPage(driver);
		menu.clickOnMenuButton();
	}

	@Then("All Menu slidebar appears.")
	public void all_menu_slidebar_appears() {
	    Assert.assertEquals(menu.verifyMenuIsOpen(),"All Items");
	}

	@When("user clicks on all items option on Menu sidebar.")
	public void user_clicks_on_all_items_option() {
	    menu.clickOnAllItemsOption();
	}

	@Then("user lands on inventory page.")
	public void user_lands_on_inventory_page() {
	   Assert.assertEquals("https://www.saucedemo.com/v1/inventory.html", menu.getUrlOfInventoryPage());
	}
}
