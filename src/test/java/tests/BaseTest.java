package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;


import java.time.Duration;


public abstract class BaseTest {

    protected Faker faker;
    protected LoginPage loginPage;
    private WebDriver driver;
    protected WebDriverWait driverWait;
    protected CitiesPage citiesPage;
    protected HomePage homePage;
    protected ProfilePage profilePage;
    protected SignUpPage signUpPage;
    protected WelcomePage welcomePage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        // driver.get("https://vue-demo.daniel-avellaneda.com/ ");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        faker = new Faker();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        citiesPage = new CitiesPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        signUpPage = new SignUpPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        welcomePage = new WelcomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }


   /* @AfterMethod
    public void afterMethod() throws InterruptedException {
        getDriverWait().withTimeout(Duration.ofSeconds(2));
    }*/


}