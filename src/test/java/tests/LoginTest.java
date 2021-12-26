package tests;

import data.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class LoginTest extends TestBase
{
	LoginPage loginObject ;

	@DataProvider(name="emptyData")
	public static Object[][] userData()
	{
		return new Object[][] {
				{"" , ""},
				{"as",""},
				{"","dsdsd"}
		};
	}

	@DataProvider(name="ExcelDataPassword")
	public Object[][] userInvalidPassword() throws IOException
	{
		ExcelReaderPassword ER = new ExcelReaderPassword();
		return ER.getExcelData();
	}

	@DataProvider(name="ExcelDataUsername")
	public Object[][] userInvalidUsername() throws IOException
	{
		ExcelReaderUsername ER = new ExcelReaderUsername();
		return ER.getExcelData();
	}


	@Test
	public void UserCanLoginSuccessfully() {
		loginObject = new LoginPage(getDriver());
		loginObject.UserLogin("tomsmith", "SuperSecretPassword!");
		Assert.assertTrue(loginObject.notificationMessage.getText().contains("You logged into a secure area!"));
		Assert.assertEquals(getDriver().getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
	}

	@Test(dataProvider = "emptyData")
	public void LoginWithEmptyData(String username, String password)
	{
		loginObject = new LoginPage(getDriver());
		loginObject.UserLogin(username, password);
		Assert.assertTrue(loginObject.notificationMessage.getText().contains("Your username is invalid!"));
	}

	@Test(dataProvider = "ExcelDataUsername")
	public void LoginWithInvalidUsername(String username, String password) {
		loginObject = new LoginPage(getDriver());
		loginObject.UserLogin(username, password);
		Assert.assertTrue(loginObject.notificationMessage.getText().contains("Your username is invalid!"));
	}

	@Test(dataProvider="ExcelDataPassword")
	public void LoginWithInvalidPassword(String username, String password) {
		loginObject = new LoginPage(getDriver());
		loginObject.UserLogin(username, password);
		Assert.assertTrue(loginObject.notificationMessage.getText().contains("Your password is invalid!"));
	}
}