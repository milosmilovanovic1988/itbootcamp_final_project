package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    private By nameField = By.id("name");

    private By phoneField = By.id("phone");

    private By cityField = By.id("city");

    private By newCity = By.id("city");

    private By country = By.id("country");

    private By twitterUrl = By.id("urlTwitter");

    private By gitHubUrl = By.id("urlGitHub");

    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");

    private By message = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");



    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getPhoneField() {
        return getDriver().findElement(phoneField);
    }

    public WebElement getCityField() {
        return getDriver().findElement(cityField);
    }

    public WebElement getNewCity() {
        return getDriver().findElement(newCity);
    }

    public WebElement getCountry() {
        return getDriver().findElement(country);
    }

    public WebElement getTwitterUrl() {
        return getDriver().findElement(twitterUrl);
    }

    public WebElement getGitHubUrl() {
        return getDriver().findElement(gitHubUrl);
    }


    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getMessage() {
        return getDriver().findElement(message);
    }


    public void editProfile(String phone, String country, String city, String twitterUrl, String gitHubUrl) throws InterruptedException {
        Thread.sleep(2000);
        getPhoneField().sendKeys(phone);

        Thread.sleep(2000);
        getCityField().click();

        Thread.sleep(2000);
        getNewCity().click();

        getCityField().sendKeys(city);
        getCityField().sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        getCountry().sendKeys(country);

        Thread.sleep(2000);
        getTwitterUrl().sendKeys(twitterUrl);

        Thread.sleep(2000);
        getGitHubUrl().sendKeys(gitHubUrl);

        Thread.sleep(2000);
        getSaveButton().click();
    }




}
