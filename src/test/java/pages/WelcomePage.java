package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends BasePage {

    private By logoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");

    private By verifyAccMsg = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");

    private By admBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");

    private By citiesBtn = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");

    private By profileBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

    private By closeModalBtn = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button");


    public WelcomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getloguouBtn() {
        return getDriver().findElement(logoutBtn);
    }

    public WebElement getVerifyAccMsg() {
        return getDriver().findElement(verifyAccMsg);
    }

    public WebElement getAdmBtn() {
        return getDriver().findElement(admBtn);
    }

    public WebElement getCitiesBtn() {
        return getDriver().findElement(citiesBtn);
    }

    public WebElement getProfileBtn() {
        return getDriver().findElement(profileBtn);
    }


    public void clickloguouBtn() {
        getloguouBtn().click();
    }

    public void clickAdminButton() {
        getAdmBtn().click();
    }

    public void clickCitiesButton() {
        getCitiesBtn().click();
    }


    public void logOutButtonWaiter() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(logoutBtn));
    }

    public void citiesButtonWaiter() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(citiesBtn));
    }

    public void closeModalButtonWaiter() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(closeModalBtn));
    }

}