package UserManagement.ProfileManagement.RegisteredUserTestCasesForChangePinCode.ValidatePasswordField;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.ProfileManagement.Scenario.ProfileManagementScenarioBasedFunctions;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

/**  VerifyEnteredPasswordIsVisibleWhenUserClicksOnDisplayPass
 * This test case Verify Entered Password is Visible when user clicks on Display Password
 * by logging registered user into Comcast application.
 * **/

public class VerifyEnteredPasswordIsVisibleWhenUserClicksOnDisplayPass extends BaseTest{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();  
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
	
	@Test
	public void testVerifyChangePinCodeDetailsUpdatedSuccessfully() throws Exception {
	userReg.testUserRegistrationUsingComcast(driver);
	
	driver.get(DataServiceProperties.APPURL);
    
    userLogin.UserLoginCredentials(driver);
    
    userLogin.ChangePassword(driver);
    Thread.sleep(4000);
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    driver.findElement(By.linkText("Change pin code")).click();
    
	driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(DataServiceProperties._PASSWORD);
    
    driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
    assertEquals(DataServiceProperties._PASSWORD, driver.findElement(By.name("password")).getAttribute("value"));
    Thread.sleep(4000);
    
    driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
    Thread.sleep(2000);
        
    driver.findElement(By.linkText("Sign out")).click();
  }
}

