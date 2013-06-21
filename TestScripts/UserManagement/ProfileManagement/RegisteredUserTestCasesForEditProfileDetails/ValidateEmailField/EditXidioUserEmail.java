package UserManagement.ProfileManagement.RegisteredUserTestCasesForEditProfileDetails.ValidateEmailField;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import ConfigServices.Utils.TestDataGenerator;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class EditXidioUserEmail extends BaseTest{
	UserRegistrationUsingComcast userRegDS=new UserRegistrationUsingComcast();
	UserLoginFunctions userLogin=new UserLoginFunctions();
	
	@Test
	  public void testEditXidioUserEmail() throws Exception {
	   
		userRegDS.testUserRegistrationUsingComcast(driver);
		
		driver.get(DataServiceProperties.APPURL);
   
	    userLogin.UserLoginCredentials(driver);
	    
	    userLogin.ChangePassword(driver);
	    Thread.sleep(4000);
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
		TestDataGenerator.updateEmailDataPropertiesFields();
		Thread.sleep(4000);
		
	    driver.findElement(By.name("user[email]")).clear();
	    driver.findElement(By.name("user[email]")).sendKeys(DataServiceProperties._UPD_EMAIL);
	    driver.findElement(By.linkText("Save profile")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
		
	    Thread.sleep(4000);
	    //assertEquals(DataServiceProperties._UPD_EMAIL, driver.findElement(By.name("user[email]")).getAttribute("value"));
		String userEmail = driver.findElement(By.name("user[email]")).getAttribute("value");
	    System.out.println("test user"+ userEmail);
	    String userTest = DataServiceProperties._UPD_EMAIL;
	    System.out.println("test user"+ userTest);
	    try {
	        assertEquals("", driver.findElement(By.cssSelector("a.logo")).getText());
	      } catch (Error e) {
	        verificationErrors.append(e.toString());
	      }
	    driver.findElement(By.linkText("Sign out")).click();
	  }

}
