package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='user-name']") WebElement username;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(id="login-button") WebElement loginButton;
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div") WebElement logo;
	@FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/h3") WebElement lockedOutError;
	
	public void enterUsername(String uname) {
		username.sendKeys(uname);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public Boolean homePageElement() {
		Boolean homePage = logo.isDisplayed();
		return homePage;
	}
	
	public String lockOutError() {
		return lockedOutError.getText();
	}
}
