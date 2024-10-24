package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfDataReader;
import utils.Driver;

public class GlobalPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(GlobalPage.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    public void navigateToHomepage() {
        Driver.get().get(ConfDataReader.get("url"));
    }

}
