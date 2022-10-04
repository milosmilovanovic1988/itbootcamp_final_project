package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public  abstract  class BasePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
