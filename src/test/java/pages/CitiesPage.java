package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage {

    private By newItemButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");

    private By cityName = By.id("name");

    private By saveButton = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");

    private By saveSuccessfullyMsg = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    private By editButton = By.id("edit");

    private By search = By.id("search");

    private By searchedCityName = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]");

    private By deleteButton = By.id("delete");

    private By modalDeleteButton = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]");

    private By deleteMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");


    public CitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNewItemBtn() {
        return getDriver().findElement(newItemButton);
    }

    public WebElement getCityName() {
        return getDriver().findElement(cityName);
    }

    public WebElement getSaveBtn() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getSuccMsg() {
        return getDriver().findElement(saveSuccessfullyMsg);
    }

    public WebElement getEditBtn() {
        return getDriver().findElement(editButton);
    }

    public WebElement getSearch() {
        return getDriver().findElement(search);
    }

    public WebElement getSearhByName() {
        return getDriver().findElement(searchedCityName);
    }

    public WebElement getDeleteBtn() {
        return getDriver().findElement(deleteButton);
    }

    public WebElement getModalDeleteBtn() {
        return getDriver().findElement(modalDeleteButton);
    }

    public WebElement getDeleteMsg() {
        return getDriver().findElement(deleteMessage);
    }

    public void createNewCity(String cityName){
        getNewItemBtn().click();
        getCityName().sendKeys(cityName);
        getSaveBtn().click();
    }

    public void editCity(String editedCityName){
        getEditBtn().click();
        getCityName().sendKeys(editedCityName);
        getSaveBtn().click();
    }

    public void searchCity(String cityName){
        getSearch().sendKeys(cityName);
    }

    public void deleteCity(){
        getDeleteBtn().click();
        getModalDeleteBtn().click();
    }

    public void getSaveWaiter() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(saveSuccessfullyMsg));
    }

    public void getSearchWaiter() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(searchedCityName));
    }

}
