package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {


    //Auth Routes Tests
    //
    //Test #1: Forbids visits to home url if not authenticated
    //assert:
    //Ucitati /home stranu kada korisnik nije ulogovan
    //Verifikovati da se u url-u stranice javlja ruta /login

    @Test
    public void homeNotAuthenticated() {
        String exRes = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/home");
        String acRes = getDriver().getCurrentUrl();
        Assert.assertEquals(acRes, exRes);
    }

    //Test #2: Forbids visits to profile url if not authenticated
    //assert:
    //Ucitati /profile stranu
    //Verifikovati da se u url-u stranice javlja ruta /login

    @Test
    public void profileNotAuthenticated() {
        String exRes = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/profile");
        String acRes = getDriver().getCurrentUrl();
        Assert.assertEquals(acRes, exRes);
    }

    //Test #3: Forbids visits to admin cities url if not authenticated
    //assert:
    //Ucitati /admin/cities stranu
    //Verifikovati da se u url-u stranice javlja ruta /login

    @Test
    public void adminCitiesNotAuthenticated() {
        String exRes = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String acRes = getDriver().getCurrentUrl();
        Assert.assertEquals(acRes, exRes);
    }

    //Test #4: Forbids visits to admin users url if not authenticated
    //assert:
    //Ucitati /admin/users stranu
    //Verifikovati da se u url-u stranice javlja ruta /login

    @Test
    public void adminUrlNotAuthenticated() {
        String exRes = "https://vue-demo.daniel-avellaneda.com/login";
        getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String acRes = getDriver().getCurrentUrl();
        Assert.assertEquals(acRes, exRes);
    }


}
