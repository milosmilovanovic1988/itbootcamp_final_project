package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Tests extends BaseTest{

    private BaseTest baseTest;

    public Tests(WebDriver driver, WebDriverWait webDriverWait, BaseTest baseTest) {
        super(driver, webDriverWait);
        this.baseTest = baseTest;
    }

    public Tests(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    public BaseTest getBaseTest() {
        return baseTest;
    }

}
