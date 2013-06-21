package UserManagement.UserRegistration.UserRegistrationTestCasesForCreditCardDetails.UserRegWithInvalidSecurityCode.UserRegWithInvalidSecurityCodeSplCharacters;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import ConfigServices.Utils.TestDataGenerator;
import Core.UserManagement.UserRegistrationFunction.Common.UserRegistrationFunction;
import Core.UserManagement.UserRegistrationFunction.Scenario.UserRegistrationValidationFuncitons;

public class RegisterToXidioApplicationWithInvalidSecurityCode extends BaseTest{
	UserRegistrationFunction useRegFun=new UserRegistrationFunction();
	UserRegistrationValidationFuncitons userRegVal=new UserRegistrationValidationFuncitons();
	@Test
  public void testRegisterToXidioApplicationWithInvalidSecurityCode() throws Exception {
		
		driver.get(DataServiceProperties.APPURL);
		Thread.sleep(4000);
	    driver.findElement(By.linkText("Register")).click();
	    Thread.sleep(2000);
	    
	    useRegFun.RegistrationDetails(driver);
	    
	    driver.findElement(By.linkText("Next")).click();
	    
	    driver.findElement(By.id("terms_conditions_accept")).click();

	    userRegVal.ValidateInvalidSecurityCodeNumber(driver);
	    
	    driver.findElement(By.cssSelector("input.change_input_type.ignore")).click();
	  
	    Thread.sleep(2000);
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter only digits in Security Code[\\s\\S]*$"));
	    driver.findElement(By.linkText("Next")).click();
	}

}
