package UserManagement.UserRegistration.UserRegistrationTestCasesForCreditCardDetails.UserRegWithNoSecurityCode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import ConfigServices.Utils.TestDataGenerator;
import Core.UserManagement.UserRegistrationFunction.Common.UserRegistrationFunction;
import Core.UserManagement.UserRegistrationFunction.Scenario.UserRegistrationValidationFuncitons;

public class RegisterToXidioApplicationWithNoSecurityCode extends BaseTest{
  	UserRegistrationFunction useRegFun=new UserRegistrationFunction();
  	UserRegistrationValidationFuncitons userRegVal=new UserRegistrationValidationFuncitons();
  	
  @Test
  public void testRegisterToXidioApplicationWithInvalidSecurityCodeLength() throws Exception {
		
		driver.get(DataServiceProperties.APPURL);
		Thread.sleep(4000);
	    driver.findElement(By.linkText("Register")).click();
	    Thread.sleep(2000);
	    
	    useRegFun.RegistrationDetails(driver);
	    
	    driver.findElement(By.name("terms_conditions")).click();
	    
	    driver.findElement(By.linkText("Next")).click();	       
	    Thread.sleep(2000);
	  
	    userRegVal.ValidateSecurityCodeMandatoryField(driver);
	    
	    driver.findElement(By.linkText("Next")).click();
	    Thread.sleep(2000);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Security Code is required[\\s\\S]*$"));
	 }
}
