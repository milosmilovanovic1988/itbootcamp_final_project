package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends  BaseTest{


    //Test #3: Set locale to FR
    //assert:
    //Postaviti jezik na FR
    //Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage


    @Test
    public void frLanguage() {
        String exRes = "Page d'atterrissage";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/ ");
        homePage.clicklanguageButton();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getFrLanguage()));
        homePage.clickFrLanguage();
        String acRes = homePage.getHeaderText().getText();
        Assert.assertEquals(acRes,exRes);
    }

    //Test #2: Set locale to EN
    //assert:
    //Postaviti jezik na EN
    //Verifikovati da se na stranici u hederu javlja tekst Landing

    @Test
    public void enLanguage() {
        String exRes = "Landing";
        homePage.clicklanguageButton();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getEnLanguage()));
        homePage.clickEnLanguage();
        String acRes = homePage.getHeaderText().getText();
        Assert.assertEquals(acRes, exRes);
    }

        //Test #1: Set locale to ES
        //assert:
        //Postaviti jezik na ES
        //Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje


        @Test
        public void esLanguage() {
            String exRes = "Página de aterrizaje";
            homePage.clicklanguageButton();
            driverWait.until(ExpectedConditions.visibilityOf(homePage.getEsLanguage()));
            homePage.clickEsLanguage();
            String acRes = homePage.getHeaderText().getText();
            Assert.assertEquals(acRes, exRes);
        }





}
