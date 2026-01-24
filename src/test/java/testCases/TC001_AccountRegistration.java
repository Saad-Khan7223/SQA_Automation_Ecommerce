package testCases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {
    @Test (groups = {"Regression","Master"})
    public void verify_account_registration() throws Throwable{
        try {


            logger.info("Starting TC_001_AccountRegistration");
            HomePage hp = new HomePage(driver);
            hp.clickMyaccount();
            logger.info("Clicked on MyAccount Link");
            hp.clickRegister();
            logger.info("Clicked on Register Link");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            logger.info("Providing details");
            regpage.setFirstName(randomString().toUpperCase());
            regpage.setLastName(randomString().toUpperCase());
            regpage.setEmail(randomString().toLowerCase() + "@gmail.com");
            regpage.setTelephone(randomNumber());

            String password = randomAlphaNumeric();

            regpage.setPassword(password);
            regpage.setConfirmPassword(password);

            regpage.setPrivacyPolicy();
            regpage.clickContinue();

            logger.info("Validation");
            String confirmsg = regpage.getConfirmationMsg();
            if(confirmsg.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
                logger.info("Test Passed");
            }
            else{
                logger.error("Test Failed");
                logger.debug("Debug Failed");
                Assert.assertTrue(false);
            }
        }
        catch (Exception e){

            Assert.fail();
        }

    }


}
