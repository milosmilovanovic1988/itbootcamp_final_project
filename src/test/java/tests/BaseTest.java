package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public abstract class BaseTest {

    protected Faker faker;
    public LoginPage loginPage;
    private WebDriver driver;
    protected WebDriverWait driverWait;
    private String baseUrl = "https://vue-demo.daniel-avellaneda.com";



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


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com/ ");}
    public WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getDriverWait() {
        return driverWait;
    }
    public LoginPage getLoginPage() {
        return loginPage;
    }





}