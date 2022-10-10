package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends  BaseTest{


    //Test #1: Visits the admin cities page and list cities
    //Podaci:
    //admin email: admin@admin.com
    //admin password: 12345
    //assert:
    //Verifikovati da se u url-u stranice javlja /admin/cities ruta
    //Verifikovati postojanje logout dugmeta

    @Test(priority = 1)
    public void  verifyCitiesPageAndListExists() {
        homePage.clickLoginBtn();
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminBtn();
        welcomePage.cityWaiter();
        welcomePage.clickCitiesBtn();
        getDriverWait().until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/admin/cities"));

        String exUrl = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        String acUrl = welcomePage.getDriver().getCurrentUrl();
        //Verifikovati da se u url-u stranice javlja /admin/cities ruta
        Assert.assertEquals(exUrl, acUrl);
        //Verifikovati postojanje logout dugmeta
        Assert.assertTrue(welcomePage.getloguouBtn().isDisplayed());
    }


    //Test #2: Create new city
    //Podaci: random grad korisćenjem faker library-ja
    //assert:
    //Verifikovati da poruka sadrzi tekst Saved successfull

    @Test(priority = 2)
    public void newCityIsCreated() {
        homePage.clickLoginBtn();
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminBtn();

        welcomePage.cityWaiter();
        welcomePage.clickCitiesBtn();

        citiesPage.createNewCity("Sabac");
        citiesPage.getSaveWaiter();

        String exRes = "Saved successfully";
        String acRes = citiesPage.getSuccMsg().getText();
        Assert.assertTrue(acRes.contains(exRes));
        //System.out.println(citiesPage.getCityName());

    }

    //Test #3: Edit city
    //Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited (primer: Beograd – Beograd edited)
    //assert:
    //Verifikovati da poruka sadrzi tekst Saved successfully

    @Test(priority = 3)
    public void cityIsEdited() {

        homePage.clickLoginBtn();
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminBtn();

        welcomePage.cityWaiter();
        welcomePage.clickCitiesBtn();

        citiesPage.editCity("Edited");
        citiesPage.getSaveWaiter();

        String exRes = "Saved successfully";
        String acRes = citiesPage.getSuccMsg().getText();
        Assert.assertTrue(acRes.contains(exRes));
    }

    //Test #4: Search city
    //Podaci: editovani grad iz testa #3
    //assert:
    //Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

    @Test(priority = 4)
    public void searchCity() {
        homePage.clickLoginBtn();
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminBtn();
        welcomePage.cityWaiter();
        welcomePage.clickCitiesBtn();
        citiesPage.searchCity("Sabac");
        citiesPage.getSearchWaiter();
        String expectedResult = "Sabac";
        String acRes = citiesPage.getSearhByName().getText();
        Assert.assertTrue(acRes.contains(expectedResult));
    }

    //Test #5: Delete city
    //Podaci: editovani grad iz testa #3
    //assert:
    //U polje za pretragu uneti staro ime grada
    //Sacekati da broj redova u tabeli bude 1
    //Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
    //Kliknuti na dugme Delete iz prvog reda
    //Sacekati da se dijalog za brisanje pojavi
    //Kliknuti na dugme Delete iz dijaloga
    //Sacekati da popu za prikaz poruke bude vidljiv
    //Verifikovati da poruka sadrzi tekst Deleted successfully

    @Test (priority = 5)
    public void deleteCity() throws InterruptedException {
        homePage.clickLoginBtn();
        String exRes = "Sabac";
        String exResMsg = "Deleted successfully";
        loginPage.login("admin@admin.com", "12345");
        welcomePage.clickAdminBtn();
        welcomePage.clickCitiesBtn();
        citiesPage.searchCity("Sabac");
        Thread.sleep(1000);
        String actualResult = citiesPage.getSearhByName().getText();
        Assert.assertTrue(actualResult.contains(exRes));
        citiesPage.deleteCity();
        Thread.sleep(1000);
        String acResMsg = citiesPage.getDeleteMsg().getText();
        Assert.assertTrue(acResMsg.contains(exResMsg));
    }



}
