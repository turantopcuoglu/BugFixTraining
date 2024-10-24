package stepdefs;

import io.cucumber.java.en.Given;
import pages.GlobalPage;

public class GlobalStepDefs {
    GlobalPage globalPage = new GlobalPage();

    @Given("navigate to home page")
    public void navigateToHomePage() {
        globalPage.navigateToHomepage();
    }
}
