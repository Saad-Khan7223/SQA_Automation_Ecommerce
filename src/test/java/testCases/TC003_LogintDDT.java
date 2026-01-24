package testCases;

// Data is valid - login success test pass logout
// Data is valid - loign failed test fail
// Data is invalid - login success  test fail logout
// Data is invalid - login failed test passed

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LogintDDT extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "DataDriven")
    public void verify_loginDDT(String email, String pwd, String exp) {
        try {

            //HomePage
            HomePage hp = new HomePage(driver);
            hp.clickMyaccount();
            hp.clickLogin();

            // Login Page
            LoginPage login = new LoginPage(driver);

//    login.loginEmail(null);
            login.loginEmail(email);

//    login.loginPassword(null);
            login.loginPassword(pwd);
            login.setBtnLogin();

            // My Account Page
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountPageExists();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    Assert.assertTrue(true);
                    myAccountPage.clickLogout();
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    Assert.assertTrue(false);
                    myAccountPage.clickLogout();
                } else {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            Assert.fail();
        }
    }

}
