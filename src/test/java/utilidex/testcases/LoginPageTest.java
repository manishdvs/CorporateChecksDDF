package utilidex.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilidex.base.TestBase;

public class LoginPageTest extends TestBase{
	
	@Test
	public void loginPageElementVerification() {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		
		//Top text verification
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("topText_css"))), "The top text is not visible");
		String topText = driver.findElement(By.cssSelector(OR.getProperty("topText_css"))).getText();
		Assert.assertEquals(topText, "View all your site's performance with customised Leaderboards");
		
		//Release Version verification
		String releaseNo = driver.findElement(By.xpath(OR.getProperty("releaseText_xpath"))).getText();
		Assert.assertTrue(releaseNo.contains(OR.getProperty("releaseNumber")));
	}
	
	@Test
	public void loginFunctionality() {
		driver.findElement(By.id(OR.getProperty("emailText_id"))).sendKeys(config.getProperty("email"));
		driver.findElement(By.id(OR.getProperty("passwordText_id"))).sendKeys(config.getProperty("password"));
		driver.findElement(By.id(OR.getProperty("signinBtn_id"))).click();
	}

}
