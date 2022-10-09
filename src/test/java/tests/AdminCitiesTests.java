package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends  BaseTest{

    @Test
    public void test1() {
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        homePage.clickLoginButton();
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();
        welcomePage.citiesButtonWaiter();
        welcomePage.clickCitiesButton();
        getDriverWait().until(ExpectedConditions.urlContains("/admin/cities"));
        String actualResultUrl = welcomePage.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultUrl,actualResultUrl);
        Assert.assertTrue(welcomePage.getloguouBtn().isDisplayed());
    }

    @Test
    public void test2() {
        homePage.clickLoginButton();
        String expectedResult = "Saved successfully";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();
        welcomePage.citiesButtonWaiter();
        welcomePage.clickCitiesButton();
        citiesPage.newCityCreate("Sabac");
        citiesPage.getSaveSuccessfullyMsgWaiter();
        String actualResult = citiesPage.getSaveSuccessfullyMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void test3() {
        homePage.clickLoginButton();
        String expectedResult = "Saved successfully";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();
        welcomePage.citiesButtonWaiter();
        welcomePage.clickCitiesButton();
        citiesPage.editCity("Edited");
        citiesPage.getSaveSuccessfullyMsgWaiter();
        String actualResult = citiesPage.getSaveSuccessfullyMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void test4() {
        homePage.clickLoginButton();
        String expectedResult = "Sabac";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();
        welcomePage.citiesButtonWaiter();
        welcomePage.clickCitiesButton();
        citiesPage.searchCity("Sabac");
        citiesPage.getSearchedCityNameWaiter();
        String actualResult = citiesPage.getSearchedCityName().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void test5() {
        homePage.clickLoginButton();
        String expectedResult = "Sabac";
        String expectedResultMsg = "Deleted successfully";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminButton();
        welcomePage.citiesButtonWaiter();
        welcomePage.clickCitiesButton();
        citiesPage.searchCity("Sabac");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
        }
        citiesPage.getSearchedCityNameWaiter();
        String actualResult = citiesPage.getSearchedCityName().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        citiesPage.deleteCity();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
        }
        String actualResultMsg = citiesPage.getDeleteMessage().getText();
        Assert.assertTrue(actualResultMsg.contains(expectedResultMsg));
    }



}
