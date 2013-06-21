package UserManagement.ProfileManagement.RegisteredUserTestCasesForChangeActivationCode.ChangeActivationCodeWithValidAC;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import ConfigServices.Utils.TestDataGenerator;
import Core.UserManagement.ProfileManagement.Scenario.ProfileManagementScenarioBasedFunctions;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

/**  ChangeUserActivationCode
 * This test case validates changing user activation code feature
 * by logging registered user into Comcast application.
 * **/

public class ValidateUserActivationCodeUpdatesSuccessfully extends BaseTest{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
		
	@Test
	public void testChangeActivationCode() throws Exception {
	userReg.testUserRegistrationUsingComcast(driver);
		
	driver.get(DataServiceProperties.APPURL);
	
	userLogin.UserLoginCredentials(driver);
    
	userLogin.ChangePassword(driver);
	Thread.sleep(4000);
	
	driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    driver.findElement(By.linkText("Change activation code")).click();
    
    driver.findElement(By.name("user[activation_code]")).clear();
    driver.findElement(By.name("user[activation_code]")).sendKeys(DataServiceProperties._UPD_ACTION_CODE);
    
    driver.findElement(By.linkText("Activate")).click();
  
   /* Thread.sleep(4000);
    driver.findElement(By.linkText("XIDIO"));
    Thread.sleep(1000);
    driver.findElement(By.linkText("XIDIO"));*/
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    driver.findElement(By.linkText("Sign out")).click();
}
}
