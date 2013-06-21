package UserManagement.ProfileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateZipField;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class EditXidioZipInProfileManagement extends BaseTest{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast(); 
	
  @Test
  public void testEditXidioZipInProfileManagement() throws Exception {
	
	userReg.testUserRegistrationUsingComcast(driver);
	  
    driver.get(DataServiceProperties.APPURL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
    
    userLogin.UserLoginCredentials(driver);
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    assertEquals(DataServiceProperties._ZIP, driver.findElement(By.name("user[zip]")).getAttribute("value"));
    
    driver.findElement(By.name("user[zip]")).clear();
    driver.findElement(By.name("user[zip]")).sendKeys(DataServiceProperties._UPD_ZIP);
    driver.findElement(By.linkText("Save profile")).click();
    
    Thread.sleep(1000);
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    driver.findElement(By.cssSelector("span.translation_missing")).click();
    assertEquals(DataServiceProperties._UPD_ZIP, driver.findElement(By.name("user[zip]")).getAttribute("value"));
    driver.findElement(By.linkText("Sign out")).click();
  }
}
