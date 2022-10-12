package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfileTests extends BaseTest {

    //Profile Tests
    //Test #1: Edits profile
    //Podaci: random podaci korišćenjem faker library-ja
    //assert:
    //Verifikovati da je prikazana poruka Profile saved successfuly
    //Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme

    @Test
    public void editProfileTest() throws InterruptedException {


        homePage.clickLoginBtn();
        homePage.clicksignUpBtn();
        signUpPage.signup(faker.name().username(), faker.internet().emailAddress(), "12345", "12345");
        welcomePage.clickClosePopUoBtn();
        welcomePage.clickProfileBtn();
        profilePage.editProfile(faker.phoneNumber().phoneNumber(), faker.country().name(), "Cali", "https://" + faker.internet().domainName(), "https://" + faker.internet().domainName());

        //Verifikovati da je prikazana poruka Profile saved successfuly
        String exRes = "Profile saved successfuly";
        String acResMsg = profilePage.getMessage().getText();
        Assert.assertTrue(acResMsg.contains(exRes));

        //Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
        String exResCountry = "text";
        String exResTel = "tel";
        String exResCity = "text";
        String exResTwitterUrl = "url";
        String exResGitHubUrl = "url";

        String acResTwitterUrl = profilePage.getTwitterUrl().getAttribute("type");
        String acResTel = profilePage.getPhoneField().getAttribute("type");
        String acResGitHubUrl = profilePage.getGitHubUrl().getAttribute("type");
        String acResCountry = profilePage.getCountry().getAttribute("type");
        String acResCity = profilePage.getCityField().getAttribute("type");

        //Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
        Assert.assertEquals(acResTel, exResTel);
        Assert.assertEquals(acResCountry, exResCountry);
        Assert.assertEquals(acResGitHubUrl, exResGitHubUrl);
        Assert.assertEquals(acResCity, exResCity);
        Assert.assertEquals(acResTwitterUrl, exResTwitterUrl);


    }
}
