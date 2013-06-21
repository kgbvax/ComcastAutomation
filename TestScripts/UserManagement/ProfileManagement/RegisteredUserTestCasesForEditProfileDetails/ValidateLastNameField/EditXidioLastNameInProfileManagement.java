package UserManagement.ProfileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateLastNameField;

import org.junit.*;
import java.io.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class EditXidioLastNameInProfileManagement extends BaseTest{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	 
  @Test
  public void testEditXidioLastNameInProfileManagement() throws Exception {
		 
	userReg.testUserRegistrationUsingComcast(driver);
	
    driver.get(DataServiceProperties.APPURL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
    
    userLogin.UserLoginCredentials(driver);
       
    userLogin.ChangePassword(driver);
    Thread.sleep(2000);
        
    driver.findElement(By.className("translation_missing")).click();    		
    driver.findElement(By.name("user[last_name]")).clear();
    driver.findElement(By.name("user[last_name]")).sendKeys(DataServiceProperties._UPD_LAST_NAME);
    driver.findElement(By.linkText("Save profile")).click();
         
    //assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Home[\\s\\S]*$"));
    Thread.sleep(4000);
    driver.findElement(By.className("translation_missing")).click();    
    assertEquals(DataServiceProperties._UPD_LAST_NAME, driver.findElement(By.name("user[last_name]")).getAttribute("value"));
    driver.findElement(By.linkText("Sign out")).click();
    
  }
}
