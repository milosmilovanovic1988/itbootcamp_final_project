package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends  BaseTest{

    //Test #1: Visits the login page
    //assert:
    //Verifikovati da se u url-u stranice javlja ruta /login

    @Test
    public void urlTest() {
        String exRes = "https://vue-demo.daniel-avellaneda.com/login";
        homePage.getWebDriverWait().until(ExpectedConditions.visibilityOf(homePage.getLoginButton()));
        homePage.clickLoginButton();
        String acRes = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(acRes, exRes);

    }

    //Test #2: Checks input types
    //assert:
    //Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //Verifikovati da polje za unos lozinke za atribut type ima vrednost password

    @Test
    public void validateEmailAndPassField() {
        String exRes = "email";
        String exResPas = "password";
        homePage.clickLoginButton();
        String accResMail = loginPage.getEmail().getAttribute("type");
        String accRessPass = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(exRes, accResMail);
        Assert.assertEquals(exResPas, accRessPass);
    }

    //Test #3: Displays errors when user does not exist
    //Podaci: random email i password koristeći faker libarary
    //asssert:
    //Verifikovati da greska sadrzi poruku User does not exists
    //Verifikovati da se u url-u stranice javlja /login ruta

    @Test
    public void userDoesNotExist() {
        String exRes = "User does not exists";
        homePage.clickLoginButton();
        String exResUrl = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());
        String acResMsg = loginPage.getErrorMessage().getText();
        Assert.assertTrue(acResMsg.contains(exRes));
        String acRes = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(exResUrl, acRes);
    }

    //Test #4: Displays errors when password is wrong
    //Podaci: email: admin@admin.com i proizvoljan password
    //
    //asssert:
    //Verifikovati da greska sadrzi poruku Wrong password
    //Verifikovati da se u url-u stranice javlja /login ruta

    @Test
    public void wrongPass() {
        String exRes = "Wrong password";
        homePage.clickLoginButton();
        String acRes = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login(" admin@admin.com", "abcde");
        String actualResMsg = loginPage.getErrorMessage().getText();
        Assert.assertTrue(actualResMsg.contains(exRes));
        String acResUrl = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(acRes, acResUrl);
    }

    //Test #5: Login
    //Podaci:
    //email: admin@admin.com
    //password: 12345
    //asssert:
    //Verifikovati da se u url-u stranice javlja /home ruta

    @Test
    public void adminLogin() {
        homePage.clickLoginButton();
        String exRes = "https://vue-demo.daniel-avellaneda.com/home";
        loginPage.login("admin@admin.com", "12345");
        getDriverWait().until(ExpectedConditions.urlContains("https://vue-demo.daniel-avellaneda.com/home"));
        String acRes = homePage.getDriver().getCurrentUrl();
        Assert.assertEquals(acRes, exRes);
    }


    //Test #6: Logout
    //assert:
    //Verifikovati da je dugme logout vidljivo na stranici
    //Verifikovati da se u url-u stranice javlja /login ruta
    //Verifikovati da se nakon pokušaja otvaranja /home rute,
    // u url-u stranice javlja /login ruta (otvoriti sa driver.get home page i proveriti da li vas redirektuje na login)

    @Test
    public void logoutTest() {
        homePage.clickLoginButton();
        String exRes = "https://vue-demo.daniel-avellaneda.com/login";
        //Verifikovati da se u url-u stranice javlja /login ruta
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/login"));
        loginPage.login("admin@admin.com", "12345");
        welcomePage.logOutButtonWaiter();
        //Verifikovati da je dugme logout vidljivo na stranici
        Assert.assertTrue(welcomePage.getloguouBtn().isDisplayed());
        welcomePage.clickloguouBtn();
        getDriverWait().until(ExpectedConditions.urlContains("/login"));
        String acRes = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(exRes, acRes);

    }



}
