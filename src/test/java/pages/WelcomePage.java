package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends BasePage {

    private By logOutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");

    private By verifyAccountMsg = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");

    private By adminButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");

    private By citiesButton = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");

    private By profileButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

    private By closeModalButton = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button");


    public WelcomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLogOutButtonWp() {
        return getDriver().findElement(logOutButton);
    }

    public WebElement getVerifyAccMsg() {
        return getDriver().findElement(verifyAccountMsg );
    }

    public WebElement getAdminButton() {
        return getDriver().findElement(adminButton);
    }

    public WebElement getCitiesButton() {
        return getDriver().findElement(citiesButton);
    }

    public WebElement getProfileButton() {
        return getDriver().findElement(profileButton);
    }

    public WebElement getCloseModalButton() {
        return getDriver().findElement(closeModalButton);
    }


    public void clickGetLogOutButtonWp() {
        getLogOutButtonWp().click();
    }

    public void clickAdminButton() {
        getAdminButton().click();
    }

    public void clickCitiesButton() {
        getCitiesButton().click();
    }

    public void clickProfileButton() {
        getProfileButton().click();
    }

    public void clickCloseModalButton(){
        getCloseModalButton().click();
    }


    public void logOutButtonWaiter() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(logOutButton));
    }

    public void citiesButtonWaiter() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(citiesButton));
    }

    public void closeModalButtonWaiter() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(closeModalButton));
    }

}