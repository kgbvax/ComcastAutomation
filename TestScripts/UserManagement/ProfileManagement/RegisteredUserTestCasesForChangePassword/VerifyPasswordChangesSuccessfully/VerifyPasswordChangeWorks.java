package UserManagement.ProfileManagement.RegisteredUserTestCasesForChangePassword.VerifyPasswordChangesSuccessfully;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class VerifyPasswordChangeWorks extends BaseTest{
	UserLoginFunctions userLogFun=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	
	@Test
  public void testVerifyPasswordChangeWorks() throws Exception {
	
	userReg.testUserRegistrationUsingComcast(driver);
	
	driver.get(DataServiceProperties.APPURL);
	
	userLogFun.UserLoginCredentials(driver);
		
	driver.findElement(By.cssSelector("span.translation_missing")).click();
	       
    driver.findElement(By.linkText("Change password")).click();
    
    userLogFun.ChangePassword(driver);
    Thread.sleep(2000);
    
    try {
        assertEquals("", driver.findElement(By.cssSelector("a.logo")).getText());
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
    driver.findElement(By.linkText("Sign out")).click();
  }
}

