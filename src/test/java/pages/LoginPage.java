package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.UserDataReader;
import utils.Utils;

public class LoginPage extends BasePage {

    UserDataReader user = new UserDataReader();
    String userType;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    public void fillEmailCredentials(String string) {
        Utils.verifyElement(username);
        username.sendKeys(user.getEmail("{string}"));
    }

    public void fillPasswordCredentials() {
        Utils.verifyElement(password);
        password.sendKeys(user.getPassword(userType));
    }

    public void clickLoginButton() {
        Utils.clickElement(loginButton);
    }
}
