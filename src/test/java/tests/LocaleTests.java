package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends  BaseTest{


    @Test
    public void frLanguage() {
        String exRes = "Page d'atterrissag";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/ ");
        homePage.clicklanguageButton();
        homePage.waitFr();
        homePage.clickFrLanguage();
        String acRes = homePage.getHeaderText().getText();
        Assert.assertEquals(acRes,exRes);
    }

  


}
