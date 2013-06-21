package DiagnoseServices.ValidateComcastWebApplicationAccessiblity.ValidateComcastAppAccessibility;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class LoginToXidioApplicationWithValidCredentials extends BaseTest{
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	
  @Test
  public void testLoginToCamcast() throws Exception {
	userReg.testUserRegistrationUsingComcast(driver);   
	  
	driver.get(DataServiceProperties.APPURL);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*User name[\\s\\S]*$"));
    driver.findElement(By.name("user[user_name]")).clear();
    driver.findElement(By.name("user[user_name]")).sendKeys(DataServiceProperties._USER_NAME);

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Password[\\s\\S]*$"));
    driver.findElement(By.name("user[password]")).clear();
    driver.findElement(By.name("user[password]")).sendKeys(DataServiceProperties._PASSWORD);
    driver.findElement(By.id("user_login")).click();
    
    Thread.sleep(5000);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sign out[\\s\\S]*$"));
    driver.findElement(By.linkText("Sign out")).click();
  }
}
