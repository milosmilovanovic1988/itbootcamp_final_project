package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

        @Test
        public void test1() {
            String exRes = "https://vue-demo.daniel-avellaneda.com/login";
            getDriver().get("https://vue-demo.daniel-avellaneda.com/home");
            String acRes = getDriver().getCurrentUrl();
            Assert.assertEquals(acRes, exRes );
        }



        @Test
        public void test2() {
            String exRes  = "https://vue-demo.daniel-avellaneda.com/login";
            getDriver().get("https://vue-demo.daniel-avellaneda.com/profile");
            String acRes = getDriver().getCurrentUrl();
            Assert.assertEquals(acRes, exRes );
        }

        @Test
        public void test3() {
            String exRes  = "https://vue-demo.daniel-avellaneda.com/login";
            getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/cities");
            String acRes = getDriver().getCurrentUrl();
            Assert.assertEquals(acRes, exRes );
        }

        @Test
        public void test4() {
            String exRes  = "https://vue-demo.daniel-avellaneda.com/login";
            getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/users");
            String acRes = getDriver().getCurrentUrl();
            Assert.assertEquals(acRes, exRes );
        }



    }
