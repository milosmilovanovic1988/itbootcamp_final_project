package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends  BaseTest {

    //Test #1: Visits the signup page
    //assert:
    //Verifikovati da se u url-u stranice javlja /signup ruta

    @Test(priority = 1)
    public void singUpTest() {
        String exResUrl = "https://vue-demo.daniel-avellaneda.com/signup";
        homePage.clicksignUpBtn();
        getDriverWait().until(ExpectedConditions.urlMatches("https://vue-demo.daniel-avellaneda.com/signup"));
        String acResUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(exResUrl, acResUrl);
    }
    //Test #3: Displays errors when user already exists
    //Podaci:
    //name: Test Test
    //email: admin@admin.com
    //password: 123654
    //confirm password: 123654
    //assert:
    //Verifikovati da greska sadrzi poruku E-mail already exists
    //Verifikovati da se u url-u stranice javlja /signup ruta

    @Test(priority = 2)
    public void emailExistTest() {
        homePage.clicksignUpBtn();
        String exRes= "E-mail already exists";
        signUpPage.signup("Test Test", "admin@admin.com", "123654", "123654");
        String acRes = signUpPage.getemailAlreadyExist().getText();
        Assert.assertTrue(acRes.contains(exRes));
    }

    //Test #4: Signup
    //Podaci:
    //name: Ime i prezime polaznika
    //email template: faker library - email
    //password: 123456
    //confirm password: 123456
    //assert:
    //Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account

    @Test(priority = 3)
    public void verifyAccountTest() throws InterruptedException {
        homePage.clicksignUpBtn();
        String exRes= "IMPORTANT: Verify your account";
        signUpPage.signup("Lignjoslav Pipak", faker.internet().emailAddress(), "987654", "987654");
        Thread.sleep(5000);
        String acRes = welcomePage.getVerifyAccMsg().getText();
        Assert.assertTrue(acRes.contains(exRes));
    }

    //Test #2: Checks input types
    //assert:
    //Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //Verifikovati da polje za unos lozinke za atribut type ima vrednost password
    //Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password

    @Test(priority = 4)
    public void inputTypesCheck() {
        homePage.clicksignUpBtn();
        String acResEmail = signUpPage.getEmailField().getAttribute("type");
        System.out.println(signUpPage.getEmailField().getAttribute("name"));
        String acResPassword = signUpPage.getPasswordField().getAttribute("type");
        String acResConfirmPassword = signUpPage.getConfirmPasswordField().getAttribute("type");

        String exResEmail = "email";
        String exResPassword = "password";
        String exResConfirmPassword = "password";

        //Verifikovati da polje za unos emaila za atribut type ima vrednost email
        Assert.assertEquals(acResEmail, exResEmail);
        //Verifikovati da polje za unos lozinke za atribut type ima vrednost password
        Assert.assertEquals(acResPassword, exResPassword);
        //Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
        Assert.assertEquals(acResConfirmPassword, exResConfirmPassword);

    }

}