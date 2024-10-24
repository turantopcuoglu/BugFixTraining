package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageStepdefs {

    LoginPage loginPage = new LoginPage();

    @Given("fill user {string}")
    public void fillUser(String a) {
        loginPage.fillEmailCredentials("{string}");
    }

    @And("fill {string} password")
    public void fillPassword(String b) {
        loginPage.fillPasswordCredentials();
    }

    @And("click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("verify successfully login")
    public void verifySuccessfullyLogin() {
        loginPage.clickLoginButton();
    }
}
