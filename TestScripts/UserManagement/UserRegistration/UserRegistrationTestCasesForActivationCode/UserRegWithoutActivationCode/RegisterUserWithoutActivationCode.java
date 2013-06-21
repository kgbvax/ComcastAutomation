package UserManagement.UserRegistration.UserRegistrationTestCasesForActivationCode.UserRegWithoutActivationCode;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import ConfigServices.Utils.TestDataGenerator;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import Core.UserManagement.UserRegistrationFunction.Common.UserRegistrationFunction;

/**  RegisterUserWithoutActivationCode
 * This test case Register user by skipping activation code 
 * by registering new user into Comcast application.
 * **/

public class RegisterUserWithoutActivationCode extends BaseTest{
	UserLoginFunctions userLogin=new UserLoginFunctions();
	UserRegistrationFunction userRegFun=new UserRegistrationFunction();
	
	@Test
	public void testChangeActivationCode() throws Exception {
	
	driver.get(DataServiceProperties.APPURL);
	Thread.sleep(4000);
    driver.findElement(By.linkText("Register")).click();
    Thread.sleep(2000);
    
    userRegFun.RegistrationDetails(driver);
    
    driver.findElement(By.name("terms_conditions")).click();
    
    driver.findElement(By.linkText("Next")).click();
         
    userRegFun.CreditCardDetials(driver);
    
    driver.findElement(By.linkText("Next")).click();

    driver.findElement(By.name("user[activation_code]")).clear();
    driver.findElement(By.name("user[activation_code]")).sendKeys(DataServiceProperties._ACTION_CODE);
    driver.findElement(By.linkText("Activate")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.name("user[activation_code]")).clear();
    driver.findElement(By.linkText("Activate")).click();
    
    Thread.sleep(4000);
    driver.findElement(By.linkText("Skip activation, go to XIDIO")).click();

    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    driver.findElement(By.linkText("Sign out")).click();
}
}
