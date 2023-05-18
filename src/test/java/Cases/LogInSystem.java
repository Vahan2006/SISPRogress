package Cases;

import Base.SetUp;
import Data.LogInMessages;
import Data.UserData;
import Locators.HomePageLocators;
import Locators.LogInLocators;
import Methods.AssertMethods;
import Methods.GeneralMethods;
import Methods.RequestMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LogInSystem {
    private static AndroidDriver driver;

    @BeforeSuite
    public void setUp() {
        SetUp setUp = new SetUp();
        driver = setUp.setUp();
    }

    @AfterMethod
    public void afterEach() {
        String appPkg = driver.getCurrentPackage();
        driver.terminateApp(appPkg);
        driver.activateApp(appPkg);
    }


    //This case will log in with valid data and assert that the username is correct
    @Test
    public void logInWithValidData() {
        GeneralMethods genMeth = new GeneralMethods(driver);
        LogInLocators loginLoc = new LogInLocators();
        UserData userData = new UserData();
        AssertMethods assertMeth = new AssertMethods(driver);
        HomePageLocators homeLock = new HomePageLocators();
        RequestMethods reqMeth = new RequestMethods(this.driver);
        reqMeth.registerRequest();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        genMeth.click(loginLoc.logInButton);
        genMeth.type(userData.getValidMail(), loginLoc.emailField);
        genMeth.type(userData.getValidPassword(), loginLoc.passwordField);
        genMeth.click(loginLoc.logInButton);
        assertMeth.waitForElementAndAssertThatContains(userData.getValidFullName(), homeLock.helloText, Duration.ofSeconds(20));
    }

    @Test
    public void logInWithInvalidFormatMail() {
        GeneralMethods genMeth = new GeneralMethods(driver);
        LogInLocators loginLoc = new LogInLocators();
        UserData userData = new UserData();
        AssertMethods assertMeth = new AssertMethods(driver);
        LogInMessages logInMessages = new LogInMessages();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        genMeth.click(loginLoc.logInButton);
        genMeth.type(userData.getInvalidFormatEmail(), loginLoc.emailField);
        genMeth.type(userData.getValidPassword(), loginLoc.passwordField);
        genMeth.click(loginLoc.logInButton);
        assertMeth.assertThatElementExists(loginLoc.wrongFormatMailError, logInMessages.wrongEmailFormatMessage);
        assertMeth.assertThatElementExists(loginLoc.invalidMailOrPasswordError, logInMessages.invalidMailMessage);

    }

    @Test
    public void logInWithInvalidEmail() {
        GeneralMethods genMeth = new GeneralMethods(driver);
        LogInLocators loginLoc = new LogInLocators();
        UserData userData = new UserData();
        AssertMethods assertMeth = new AssertMethods(driver);
        LogInMessages logInMessages = new LogInMessages();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        genMeth.click(loginLoc.logInButton);
        genMeth.type(userData.getInvalidEmail(), loginLoc.emailField);
        genMeth.type(userData.getValidPassword(), loginLoc.passwordField);
        genMeth.click(loginLoc.logInButton);
        assertMeth.assertThatElementExists(loginLoc.invalidMailOrPasswordError, logInMessages.invalidMailMessage);
    }

    @Test
    public void logInWithInvalidPassword() {
        GeneralMethods genMeth = new GeneralMethods(driver);
        LogInLocators loginLoc = new LogInLocators();
        UserData userData = new UserData();
        AssertMethods assertMeth = new AssertMethods(driver);
        LogInMessages logInMessages = new LogInMessages();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        genMeth.click(loginLoc.logInButton);
        genMeth.type(userData.getValidMail(), loginLoc.emailField);
        genMeth.type(userData.getInvalidPassword(), loginLoc.passwordField);
        genMeth.click(loginLoc.logInButton);
        assertMeth.assertThatElementExists(loginLoc.invalidMailOrPasswordError, logInMessages.invalidMailMessage);
    }

}
