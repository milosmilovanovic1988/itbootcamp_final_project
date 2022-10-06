package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public  abstract  class BasePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private WebElement webElement;

    public BasePage(WebDriver driver, WebDriverWait driverWait) {
    }

    public BasePage(WebDriver driver, WebDriverWait webDriverWait, WebElement webElement) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        this.webElement = webElement;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public WebElement getWebElement() {
        return webElement;
    }
}
