package VideoManagement.VideoFeedBackManagement.ValidateMandatoryFields;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

/**
 * ValidateFeedbackSubjectMandatoryField 
 * This test case validates the subject mandatory fields of give feedback to the publisher
 * feature for the selected video by logging registered user into Comcast
 * application.
 * **/

public class ValidateFeedbackMessageMandatoryField extends BaseTest {

	UserLoginFunctions userLogin = new UserLoginFunctions();
	UserRegistrationUsingComcast userReg = new UserRegistrationUsingComcast();

	@Test
	public void testfeedback() throws Exception {
		userReg.testUserRegistrationUsingComcast(driver);

		driver.get(DataServiceProperties.APPURL);

		userLogin.UserLoginCredentials(driver);

		userLogin.ChangePassword(driver);

		Thread.sleep(2000);
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
				.matches("^[\\s\\S]*XIDIO[\\s\\S]*$"));
		assertEquals(
				"",
				driver.findElement(
						By.xpath("//img[@alt='Comcast Labs, XIDIO']"))
						.getText());
		driver.findElement(By.id("search-query")).clear();
		driver.findElement(By.id("search-query")).sendKeys(
				DataServiceProperties._SEARCH_VIDEO_BY);
		driver.findElement(By.id("go-search")).click();

		driver.findElement(By.cssSelector("img[alt=\"African Cats\"]")).click();

		driver.findElement(By.linkText("Give Feedback")).click();
		
		driver.findElement(By.xpath("(//textarea[@name='message'])[2]"))
		.clear();
		driver.findElement(By.xpath("(//textarea[@name='message'])[2]"))
		.sendKeys("This video is wonderfull.");

		driver.findElement(By.xpath("(//input[@name='Submit'])[2]")).click();
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
				.matches("^[\\s\\S]*Subject is required[\\s\\S]*$"));
		
		driver.findElement(By.linkText("Sign out")).click();

	}
}
