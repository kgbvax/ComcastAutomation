package UserManagement.ProfileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateFirstNameField;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class ValidateFirstNameFieldByDeletingValue extends BaseTest{
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
  @Test
  public void testValidateUserNameFieldByDeletingValueInPM() throws Exception {
	
	userReg.testUserRegistrationUsingComcast(driver);
	
	driver.get(DataServiceProperties.APPURL);
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));	
	
	userLogin.UserLoginCredentials(driver);
	
	userLogin.ChangePassword(driver);
	Thread.sleep(4000);
    
	driver.findElement(By.cssSelector("span.translation_missing")).click();
    driver.findElement(By.name("user[first_name]")).clear();
    driver.findElement(By.name("user[first_name]")).sendKeys("");
    driver.findElement(By.linkText("Save profile")).click();
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*First name is required[\\s\\S]*$"));
    driver.findElement(By.linkText("Sign out")).click();
  }
}
