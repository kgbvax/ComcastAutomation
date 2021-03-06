package UserManagement.ProfileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateAddressField;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class EditXidioAddressInProfileManagement extends BaseTest{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();  
	
  @Test
  public void testEditXidioAddressInProfileManagement() throws Exception {
	
	userReg.testUserRegistrationUsingComcast(driver);
	  
	driver.get(DataServiceProperties.APPURL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
    
    userLogin.UserLoginCredentials(driver);

	driver.findElement(By.cssSelector("span.translation_missing")).click();
   
    driver.findElement(By.name("user[address]")).clear();
    driver.findElement(By.name("user[address]")).sendKeys(DataServiceProperties._UPD_ADDRESS);
    driver.findElement(By.linkText("Save profile")).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));

    driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    assertEquals(DataServiceProperties._UPD_ADDRESS, driver.findElement(By.name("user[address]")).getAttribute("value"));
    
    driver.findElement(By.linkText("Sign out")).click();
 
  }
}
