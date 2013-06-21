package UserManagement.UserRegistration.UserRegistrationTestCasesForCreditCardDetails.UserRegWithInvalidCCNumber;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import ConfigServices.Utils.TestDataGenerator;
import Core.UserManagement.UserRegistrationFunction.Common.UserRegistrationFunction;
import Core.UserManagement.UserRegistrationFunction.Scenario.UserRegistrationValidationFuncitons;

public class RegisterToXidioApplicationWithInvalidCreditCardNumber extends BaseTest {
	UserRegistrationFunction useRegFun=new UserRegistrationFunction();
	UserRegistrationValidationFuncitons userRegVal=new UserRegistrationValidationFuncitons();
	
  @Test
  public void testRegisterToXidioApplicationWithInvalidCreditCardNumber() throws Exception {
	
	driver.get(DataServiceProperties.APPURL);
	Thread.sleep(4000);
    driver.findElement(By.linkText("Register")).click();
    Thread.sleep(2000);
    
    useRegFun.RegistrationDetails(driver);
    driver.findElement(By.name("terms_conditions")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(2000);
    
	driver.findElement(By.name("user[cc_number]")).clear();
    driver.findElement(By.name("user[cc_number]")).sendKeys(DataServiceProperties._INVALID_CC_NUMBER);    
    //userRegVal.ValidateInvalidCreditCardNumber(driver);
    
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(2000);
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter a valid credit card number[\\s\\S]*$"));
    /*try{
    	String AssertCCError="Please enter a valid credit card number";
    	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*'"+AssertCCError+"'[\\s\\S]*$"));
    }
    catch(Exception e){
    	
    }*/
  }

private void assertEqual(String string, String text) {
	// TODO Auto-generated method stub
	
}
}
