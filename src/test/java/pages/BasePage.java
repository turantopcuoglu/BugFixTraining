package pages;

import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
        Driver.get().manage().window().maximize();
    }
}
