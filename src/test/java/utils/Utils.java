package utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    public static Duration waitDuration = Duration.ofSeconds(parseInt(ConfDataReader.get("default_wait_time")));

    public static void verifyElement(WebElement _element, long _time) {
        Duration _duration = Duration.ofMillis(_time);
        WebDriver driver = Driver.get(); // WebDriver instance
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        WebDriverWait wait = new WebDriverWait(driver, _duration);

        try {
            WebElement element = wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    try {
                        return _element.isDisplayed() && _element.isEnabled() ? _element : null;
                    } catch (StaleElementReferenceException e) {
                        return null;
                    }
                }
            });
        } catch (TimeoutException e) {
            logger.info("Element is not visible within the given time.");
            throw e;
        }
    }

    public static void verifyElement(WebElement _element) {
        WebDriver driver = Driver.get(); // WebDriver instance
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebDriverWait wait = new WebDriverWait(driver, waitDuration);

        try {
            WebElement element = wait.until(driver1 -> {
                try {
                    return _element.isDisplayed() && _element.isEnabled() ? _element : null;
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            });
        } catch (TimeoutException e) {
            logger.info("Element is not visible within the given time.");

        }
    }

    public static boolean isElementVisible(WebElement _element) {
        WebDriver driver = Driver.get(); // WebDriver instance
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebDriverWait wait = new WebDriverWait(driver, waitDuration);

        try {
            wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    try {
                        return _element.isDisplayed() && _element.isEnabled() ? _element : null;
                    } catch (StaleElementReferenceException e) {
                        return null;
                    }
                }
            });
            return true;
        } catch (TimeoutException e) {
            logger.info("Element is not visible within the given time.");
            return false;
        }
    }

    public static boolean isElementVisible(WebElement _element, long _time) {
        Duration _duration = Duration.ofMillis(_time);
        WebDriver driver = Driver.get(); // WebDriver instance
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        WebDriverWait wait = new WebDriverWait(driver, _duration);

        try {
            wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    try {
                        return _element.isDisplayed() && _element.isEnabled() ? _element : null;
                    } catch (StaleElementReferenceException e) {
                        return null;
                    }
                }
            });
            logger.info("Element is visible and enabled.");
            return true;
        } catch (TimeoutException e) {
            logger.info("Element is not visible within the given time.");
            return false;
        }
    }

    public static void clickElement(WebElement _element) {
        verifyElement(_element);
        _element.click();
    }

    public static void clickElement(WebElement _element, long _time) {
        verifyElement(_element, _time);
        _element.click();
    }

    public static void verifyElementText(WebElement _element, String expectedText) {
        verifyElement(_element);
        Assert.assertEquals(_element.getText(), expectedText);
    }

    public static void verifyElementContainsText(WebElement _element, String expectedText) {
        verifyElement(_element);
        Assert.assertTrue(_element.getText().contains(expectedText));
    }

    public static void staticWait(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }

    public static void waitForLoadingBarToDisappear() {
        new WebDriverWait(Driver.get(), waitDuration).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                try {
                    WebElement loadingBar = d.findElement(By.id("linearProgressBar"));
                    return !loadingBar.isDisplayed();
                } catch (NoSuchElementException e) {
                    return true;
                }
            }
        });
    }
}
