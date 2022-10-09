package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends  BaseTest {

    @Test
    public void singUpTest1() {
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/signup";
        homePage.clicksignUpButton();
        getDriverWait().until(ExpectedConditions.urlContains("/signup"));
        String actualResultUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultUrl, actualResultUrl);
    }

    @Test
    public void singUpTest2() {
        homePage.clicksignUpButton();
        String expectedResult = "E-mail already exists";
        signUpPage.signup("Milos Milovanovic", "milosm@gmail.com", "abc321", "abc321");
        String actualResult = signUpPage.getemailAlreadyExist().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void singUpTest3() {
        homePage.clicksignUpButton();
        String expectedResult = "IMPORTANT: Verify your account";
        signUpPage.signup("Lignjoslav Pipak", "lignjica@kebakraba.com", "987654", "987654");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        String actualResult = welcomePage.getVerifyAccMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void singUpTest4() {
        homePage.clicksignUpButton();
        String actualResultEmail = signUpPage.getEmailField().getAttribute("type");
        String actualResultPassword = signUpPage.getPasswordField().getAttribute("type");
        String actualResultConfirmPassword = signUpPage.getConfirmPasswordField().getAttribute("type");
        String expectedResultEmail = "email";
        String expectedResultPassword = "password";
        String expectedResultConfirmPassword = "password";
        Assert.assertEquals(actualResultEmail, expectedResultEmail);
        Assert.assertEquals(actualResultPassword, expectedResultPassword);
        Assert.assertEquals(actualResultConfirmPassword, expectedResultConfirmPassword);

    }


}