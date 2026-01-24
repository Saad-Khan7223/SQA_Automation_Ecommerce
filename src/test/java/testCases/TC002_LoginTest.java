package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test (groups = {"Sanity","Master"})
public void verify_login(){
        logger.info("Starting TC_002 Login Test");
try {
    //HomePage
    HomePage hp=new HomePage(driver);
    hp.clickMyaccount();
    hp.clickLogin();

    // Login Page
    LoginPage login=new LoginPage(driver);

//    login.loginEmail(null);
    login.loginEmail(p.getProperty("email"));

//    login.loginPassword(null);
    login.loginPassword(p.getProperty("password"));
//    login.loginPassword("saadqweer");
    login.setBtnLogin();

    // My Account Page
    MyAccountPage myAccountPage=new MyAccountPage(driver);
    boolean targetPage=myAccountPage.isMyAccountPageExists();

  Assert.assertEquals(targetPage,true,"Login failed");
    //Assert.assertTrue(myAccountPage.isMyAccountPageExists());
} catch (Exception e) {
    Assert.fail();
}


        logger.info("Finihsed Login Test");


}

}
