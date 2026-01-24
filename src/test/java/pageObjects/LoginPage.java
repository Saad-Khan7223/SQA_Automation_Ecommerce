package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement getTxtEmail;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement getTxtPassword;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

public  void loginEmail (String email){
    getTxtEmail.sendKeys(email);
}
public  void loginPassword (String password) {
    getTxtPassword.sendKeys(password);
}
public void setBtnLogin(){
    btnLogin.click();
}


}
