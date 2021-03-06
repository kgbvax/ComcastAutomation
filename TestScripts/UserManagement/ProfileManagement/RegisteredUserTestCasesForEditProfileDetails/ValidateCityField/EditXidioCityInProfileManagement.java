package UserManagement.ProfileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateCityField;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class EditXidioCityInProfileManagement extends BaseTest{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg = new UserRegistrationUsingComcast();
	
	@Test
  public void testEditXidioCityInProfileManagement() throws Exception {
	userReg.testUserRegistrationUsingComcast(driver);
	driver.get(DataServiceProperties.APPURL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign In[\\s\\S]*$"));
    
    userLogin.UserLoginCredentials(driver);
	driver.findElement(By.cssSelector("span.translation_missing")).click();
           
    driver.findElement(By.name("user[city]")).clear();
    driver.findElement(By.name("user[city]")).sendKeys(DataServiceProperties._UPD_CITY);
    driver.findElement(By.linkText("Save profile")).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	
	driver.findElement(By.cssSelector("span.translation_missing")).click();
    
    assertEquals(DataServiceProperties._UPD_CITY, driver.findElement(By.name("user[city]")).getAttribute("value"));
    driver.findElement(By.linkText("Sign out")).click();
  }
}
