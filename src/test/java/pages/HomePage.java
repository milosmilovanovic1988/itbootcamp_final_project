package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By homeButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/a[1]");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    private By signUpButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/a[4]");
    private By languageButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button");
    private By enLanguage = By.xpath("//*[@id=\"list-item-73\"]");
    private By esLanguage = By.xpath("//*[@id=\"list-item-75\"]");
    private By frLanguage = By.xpath("//*[@id=\"list-item-77\"]");
    private By headerText = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");


    public HomePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }
    public WebElement getHomeButton() {
        return getDriver().findElement(homeButton);
    }
    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }
    public WebElement getSignUpButton() {
        return getDriver().findElement(signUpButton);
    }
    public WebElement getLanguageButton() {
        return getDriver().findElement(languageButton);
    }
    public WebElement getEnLanguage() {
        return getDriver().findElement(enLanguage);
    }
    public WebElement getEsLanguage() {
        return getDriver().findElement(esLanguage);
    }
    public WebElement getFrLanguage() {
        return getDriver().findElement(frLanguage);
    }
    public WebElement getHeaderText() {
        return getDriver().findElement(headerText);
    }
    public void clickHomeButton(){
        getHomeButton().click();
    }
    public void clickLoginButton(){
        getLoginButton().click();
    }
    public void clicksignUpButton(){
        getSignUpButton().click();
    }
    public void clicklanguageButton(){
        getLanguageButton().click();
    }
    public void clickEnLanguage(){
        getEnLanguage().click();
    }
    public void clickEsLanguage(){
        getEsLanguage().click();
    }
    public void clickFrLanguage(){
        getFrLanguage().click();
    }
    public void waitEn(){
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(enLanguage));
    }
    public void waitFr(){
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(frLanguage));
    }
    public void waitEs(){
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(esLanguage));
    }











}


