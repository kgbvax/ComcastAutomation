package UserManagement.ProfileManagement.RegisteredUserTestCasesForChangePaymentInfo.ValidateExpiryMonthField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.ProfileManagement.Scenario.ProfileManagementScenarioBasedFunctions;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

/**  ValidatePaymentInfoMonthMandatoryField
 * This test case validates payment Details Month Mandatory field
 * By logging registered user into Comcast application.
 * **/

public class ValidatePaymentInfoMonthMandatoryField extends BaseTest{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
	
	@Test
	  public void testUserProfileChanges() throws Exception {
		userReg.testUserRegistrationUsingComcast(driver);
		
		driver.get(DataServiceProperties.APPURL);
		
		userLogin.UserLoginCredentials(driver);

		userLogin.ChangePassword(driver);
		Thread.sleep(4000);
		
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change payment info")).click();
	    
	    profMangScenarioFun.ValidatePaymentInfoMonthMandatoryField(driver);
	    
	    driver.findElement(By.name("commit")).click();
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Expiration Month is required[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("#uniform-undefined > span")).click();
	    
	    Thread.sleep(1000);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Payment info has not been updated[\\s\\S]*$"));
	    
	    driver.findElement(By.linkText("Sign out")).click();
}
}

