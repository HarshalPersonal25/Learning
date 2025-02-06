package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class menuPage {
	
WebDriver driver;
	
	public menuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space()='Open Menu']") WebElement menuButton;
	@FindBy(linkText = "All Items") WebElement allItemsOption;
	
	public void clickOnMenuButton() {
		menuButton.click();
	}
	
	public String verifyMenuIsOpen() {
		return allItemsOption.getText();
	}
	
	public void clickOnAllItemsOption() {
		allItemsOption.click();
	}
	
	public String getUrlOfInventoryPage() {
		return driver.getCurrentUrl();
	}
}