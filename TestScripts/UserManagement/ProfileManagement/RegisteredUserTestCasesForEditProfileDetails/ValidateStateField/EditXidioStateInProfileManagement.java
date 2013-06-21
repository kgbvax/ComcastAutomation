package UserManagement.ProfileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateStateField;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class EditXidioStateInProfileManagement extends BaseTest{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	
  @Test
  public void testEditXidioStateInProfileManagement() throws Exception {
	 
	userReg.testUserRegistrationUsingComcast(driver); 
	
    driver.get(DataServiceProperties.APPURL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
    
    userLogin.UserLoginCredentials(driver);
     
    driver.findElement(By.className("translation_missing")).click();  
    new Select(driver.findElement(By.name("user[state]"))).selectByVisibleText("AL - Alabama");
    driver.findElement(By.cssSelector("option[value=\"AL\"]")).click();
    driver.findElement(By.linkText("Save profile")).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
    driver.findElement(By.className("translation_missing")).click(); 
    driver.findElement(By.linkText("Sign out")).click();
	
	//Need to assert changed state from drop down.
	//==========================
	
  }
}

