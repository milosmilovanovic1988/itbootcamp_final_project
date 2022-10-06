package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends  BaseTest{

    @Test
    public void loginTest1() {
        String exRes = "https://vue-demo.daniel-avellaneda.com/login";
        homePage.getWebDriverWait().until(ExpectedConditions.visibilityOf(homePage.getLoginButton()));
        homePage.clickLoginButton();
        String acRes = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(acRes, exRes);
    }

    @Test
    public void loginTest2() {
        String exRes = "email";
        String expectedResultPassword = "password";
        homePage.clickLoginButton();
        String actualResultEmail = loginPage.getEmail().getAttribute("type");
        String actualResultPassword = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(exRes, actualResultEmail);
        Assert.assertEquals(expectedResultPassword, actualResultPassword);
    }
    @Test
    public void loginTest3() {
        String exRes = "User does not exists";
        homePage.clickLoginButton();
        String exResUrl = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());
        String actualResultMessage = loginPage.getErrorMessage().getText();
        Assert.assertTrue(actualResultMessage.contains(exRes));
        String acRes = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(exResUrl, acRes);
    }

    @Test
    public void loginTest4() {
        String exRes = "Wrong password";
        homePage.clickLoginButton();
        String acRes = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login(" admin@admin.com", faker.internet().password());
        String actualResultMessage = loginPage.getErrorMessage().getText();
        Assert.assertTrue(actualResultMessage.contains(exRes));
        String actualResultUrl = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(acRes, actualResultUrl);
    }

    @Test
    public void loginTest5() {
        homePage.clickLoginButton();
        String exRes = "https://vue-demo.daniel-avellaneda.com/home";
        loginPage.login("admin@admin.com", "12345");
        getDriverWait().until(ExpectedConditions.urlContains("/home"));
        String acRes = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(acRes, exRes);
    }

    @Test
    public void loginTest6() {
        homePage.clickLoginButton();
        String exRes = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.logOutButtonWaiter();
        welcomePage.clickGetLogOutButtonWp();
        getDriverWait().until(ExpectedConditions.urlContains("/login"));
        String acRes = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(exRes, acRes);
    }



}
