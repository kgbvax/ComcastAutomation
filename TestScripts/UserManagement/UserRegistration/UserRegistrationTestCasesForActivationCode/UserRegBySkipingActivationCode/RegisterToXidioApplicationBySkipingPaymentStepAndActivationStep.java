package UserManagement.UserRegistration.UserRegistrationTestCasesForActivationCode.UserRegBySkipingActivationCode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserRegistrationFunction.Common.UserRegistrationFunction;

public class RegisterToXidioApplicationBySkipingPaymentStepAndActivationStep extends BaseTest{
	UserRegistrationFunction urf=new UserRegistrationFunction();
	
	@Test
  public void testRegistrationToXidioApplicationBySkipingPaymentStepAndActivationStep() throws Exception {
	driver.get(DataServiceProperties.APPURL);
	driver.findElement(By.linkText("Register")).click();
	
	//Calling UserRegistration Function
    urf.RegistrationDetails(driver);
    driver.findElement(By.name("terms_conditions")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(2000);
    //driver.findElement(By.id("terms_conditions_accept")).click();
    driver.findElement(By.linkText("Skip this step")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Skip activation, go to XIDIO")).click();
    Thread.sleep(2000);
    
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.linkText("Sign out")).click();
  }
}

