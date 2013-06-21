package UserManagement.ProfileManagement.RegisteredUserTestCasesForChangePaymentInfo.ValidateYearField;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import ConfigServices.Utils.TestDataGenerator;
import Core.UserManagement.ProfileManagement.Scenario.ProfileManagementScenarioBasedFunctions;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

/**  ValidatePaymentInfoYearFieldByEnteringPastYear
 * This test case validates payment Details Year field By entering Past Year
 * By logging registered user into Comcast application.
 * **/

public class ValidatePaymentInfoYearFieldByEnteringPastYear extends BaseTest{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
	ProfileManagementScenarioBasedFunctions profMangScenarioFun=new ProfileManagementScenarioBasedFunctions();
	
	@Test
	  public void testUserProfileChanges() throws Exception {
		
		userReg.testUserRegistrationUsingComcast(driver);
				
		Thread.sleep(4000);
		driver.get(DataServiceProperties.APPURL);
		
		userLogin.UserLoginCredentials(driver);

		userLogin.ChangePassword(driver);
		Thread.sleep(4000);
		
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
	    
	    driver.findElement(By.cssSelector("span.translation_missing")).click();
	    
	    driver.findElement(By.linkText("Change payment info")).click();
	    
	    profMangScenarioFun.ValidateYearFieldByEnteringPastYear(driver);
	        
	    driver.findElement(By.name("commit")).click();
	    
	    Thread.sleep(2000);								
	    
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter Expiration Year greater than or equal to "+DataServiceProperties._CURRENT_YEAR+"\\.[\\s\\S]*$"));
	   
	    driver.findElement(By.cssSelector("#uniform-undefined > span")).click();
	    
	    driver.findElement(By.linkText("Sign out")).click();  
}
}

