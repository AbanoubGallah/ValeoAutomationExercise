package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="username")
	public WebElement usernameTxtBox ;

	@FindBy(id="password")
	public WebElement passwordTxtBox ;

	@FindBy(className="radius")
	WebElement loginBtn ;

	@FindBy(id="flash")
	public WebElement notificationMessage;

	public void UserLogin(String username , String password)
	{
		setTextElementText(usernameTxtBox, username);
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}
}
