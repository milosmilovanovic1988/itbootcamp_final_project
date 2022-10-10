package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By loginIcon = By.xpath("/html/body/div/div/div/header/div/div[3]/a[3]/span");
    private By email = By.id("email");
    private By password = By.id("password");
    private By logInBtn = By.xpath("/html/body/div/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");
    private By errorMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");


    public LoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getLoginIcon() {
        return getDriver().findElement(loginIcon);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getLogInBtn() {
        return getDriver().findElement(logInBtn);
    }

    public WebElement getErrorMsg() {
        return getDriver().findElement(errorMessage);
    }

    public void login(String email, String password) {
        getEmail().clear();
        getPassword().clear();
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLogInBtn().click();
    }


}
