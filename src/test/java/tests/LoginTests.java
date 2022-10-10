package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends  BaseTest{

    //Test #1: Visits the login page
    //assert:
    //Verifikovati da se u url-u stranice javlja ruta /login

    @Test(priority = 1)
    public void urlTest() {

        homePage.clickLoginBtn();
        String exRes = "https://vue-demo.daniel-avellaneda.com/login";
        String acRes = homePage.getDriver().getCurrentUrl();
        //Verifikovati da se u url-u stranice javlja ruta /login
        Assert.assertEquals(acRes, exRes);

    }

    //Test #2: Checks input types
    //assert:
    //Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //Verifikovati da polje za unos lozinke za atribut type ima vrednost password

    @Test(priority = 2)
    public void validateEmailAndPassField() {
        homePage.clickLoginBtn();

        String exRes = "email";
        String exResPas = "password";

        String accResMail = loginPage.getEmail().getAttribute("type");
        String accRessPass = loginPage.getPassword().getAttribute("type");
        //Verifikovati da polje za unos emaila za atribut type ima vrednost email
        Assert.assertEquals(exRes, accResMail);
        //Verifikovati da polje za unos lozinke za atribut type ima vrednost password
        Assert.assertEquals(exResPas, accRessPass);
    }

    //Test #3: Displays errors when user does not exist
    //Podaci: random email i password koristeći faker libarary
    //asssert:
    //Verifikovati da greska sadrzi poruku User does not exists
    //Verifikovati da se u url-u stranice javlja /login ruta

    @Test(priority = 3)
    public void userDoesNotExist() {
        homePage.clickLoginBtn();
        String exResUrl = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());
        String acResMsg = loginPage.getErrorMsg().getText();

        String exRes = "User does not exists";
        //Verifikovati da greska sadrzi poruku User does not exists
        Assert.assertTrue(acResMsg.contains(exRes));
        String acRes = homePage.getDriver().getCurrentUrl();
        //Verifikovati da se u url-u stranice javlja /login ruta
        Assert.assertEquals(exResUrl, acRes);
    }

    //Test #4: Displays errors when password is wrong
    //Podaci: email: admin@admin.com i proizvoljan password
    //
    //asssert:
    //Verifikovati da greska sadrzi poruku Wrong password
    //Verifikovati da se u url-u stranice javlja /login ruta

    @Test(priority = 4)
    public void wrongPass() {

        homePage.clickLoginBtn();
        String acRes = "https://vue-demo.daniel-avellaneda.com/login";
        loginPage.login(" admin@admin.com", "abcde");

        String exRes = "Wrong password";
        String actualResMsg = loginPage.getErrorMsg().getText();
        //Verifikovati da greska sadrzi poruku Wrong password
        Assert.assertTrue(actualResMsg.contains(exRes));

        String acResUrl = homePage.getDriver().getCurrentUrl();
        //Verifikovati da se u url-u stranice javlja /login ruta
        Assert.assertEquals(acRes, acResUrl);
    }

    //Test #5: Login
    //Podaci:
    //email: admin@admin.com
    //password: 12345
    //asssert:
    //Verifikovati da se u url-u stranice javlja /home ruta

    @Test(priority = 5)
    public void adminLogin() {
        homePage.clickLoginBtn();
        loginPage.login("admin@admin.com", "12345");

        getDriverWait().until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/home"));

        String exRes = "https://vue-demo.daniel-avellaneda.com/home";
        String acRes = homePage.getDriver().getCurrentUrl();
        //Verifikovati da se u url-u stranice javlja /home ruta
        Assert.assertEquals(acRes, exRes);
    }


    //Test #6: Logout
    //assert:
    //Verifikovati da je dugme logout vidljivo na stranici
    //Verifikovati da se u url-u stranice javlja /login ruta
    //Verifikovati da se nakon pokušaja otvaranja /home rute,
    // u url-u stranice javlja /login ruta (otvoriti sa driver.get home page i proveriti da li vas redirektuje na login)

    @Test(priority = 6)
    public void logoutTest() {
        homePage.clickLoginBtn();
        String exRes = "https://vue-demo.daniel-avellaneda.com/login";
        //Verifikovati da se u url-u stranice javlja /login ruta
        Assert.assertTrue(getDriver().getCurrentUrl().equals("https://vue-demo.daniel-avellaneda.com/login"));

        loginPage.login("admin@admin.com", "12345");
        welcomePage.logOutWaiter();

        //Verifikovati da je dugme logout vidljivo na stranici
        Assert.assertTrue(welcomePage.getloguouBtn().isDisplayed());
        welcomePage.clickloguouBtn();

        getDriverWait().until(ExpectedConditions.urlContains("/login"));
        String acRes = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(exRes, acRes);

    }



}
