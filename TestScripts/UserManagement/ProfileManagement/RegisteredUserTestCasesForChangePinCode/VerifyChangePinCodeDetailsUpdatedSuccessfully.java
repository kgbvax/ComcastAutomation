package UserManagement.ProfileManagement.RegisteredUserTestCasesForChangePinCode;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class VerifyChangePinCodeDetailsUpdatedSuccessfully extends BaseTest{
  UserLoginFunctions userLogin=new UserLoginFunctions();
  UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
  
  @Test
  public void testVerifyChangePinCodeDetailsUpdatedSuccessfully() throws Exception {
	
	userReg.testUserRegistrationUsingComcast(driver);
	  
	driver.get(DataServiceProperties.APPURL);
    
    userLogin.UserLoginCredentials(driver);
    
    userLogin.ChangePassword(driver);
    Thread.sleep(4000);
    
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    driver.findElement(By.linkText("Change pin code")).click();
    driver.findElement(By.name("cc_pin_code")).clear();
    driver.findElement(By.name("cc_pin_code")).sendKeys(DataServiceProperties._CC_PIN_CODE);
    
        
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(DataServiceProperties._PASSWORD);
   
    driver.findElement(By.name("commit")).click();
    try {
        assertEquals("", driver.findElement(By.cssSelector("a.logo")).getText());
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
    driver.findElement(By.linkText("Sign out")).click();
  }
}

