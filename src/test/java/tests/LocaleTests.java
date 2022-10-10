package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends  BaseTest{


    //Test #3: Set locale to FR
    //assert:
    //Postaviti jezik na FR
    //Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage


    @Test (priority = 1)
    public void frLanguage() {
        homePage.clicklanguageBtn();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getFrLanguage()));
        homePage.clickFrLanguage();

        String exRes = "Page d'atterrissage";
        String acRes = homePage.getHeaderText().getText();
        Assert.assertEquals(acRes,exRes);
    }

    //Test #2: Set locale to EN
    //assert:
    //Postaviti jezik na EN
    //Verifikovati da se na stranici u hederu javlja tekst Landing

    @Test(priority = 2)
    public void enLanguage() {

        homePage.clicklanguageBtn();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getEnLanguage()));
        homePage.clickEnLanguage();

        String exRes = "Landing";
        String acRes = homePage.getHeaderText().getText();
        Assert.assertEquals(acRes, exRes);
    }

        //Test #1: Set locale to ES
        //assert:
        //Postaviti jezik na ES
        //Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje


        @Test(priority = 3)
        public void esLanguage() {

            homePage.clicklanguageBtn();
            driverWait.until(ExpectedConditions.visibilityOf(homePage.getEsLanguage()));
            homePage.clickEsLanguage();

            String exRes = "Página de aterrizaje";
            String acRes = homePage.getHeaderText().getText();
            Assert.assertEquals(acRes, exRes);
        }





}
