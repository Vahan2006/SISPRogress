package Base;

import Data.UserData;
import Locators.HomePageLocators;
import Locators.LogInLocators;
import Methods.AssertMethods;
import Methods.GeneralMethods;
import Methods.RequestMethods;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LogIn {
    public LogIn(AndroidDriver driver){
        GeneralMethods genMeth = new GeneralMethods(driver);
        LogInLocators loginLoc = new LogInLocators();
        UserData userData = new UserData();
        AssertMethods assertMeth = new AssertMethods(driver);
        HomePageLocators homeLock = new HomePageLocators();
        RequestMethods reqMeth = new RequestMethods(driver);
        reqMeth.registerRequest();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        genMeth.click(loginLoc.logInButton);
        genMeth.type(userData.getValidMail(), loginLoc.emailField);
        genMeth.type(userData.getValidPassword(), loginLoc.passwordField);
        genMeth.click(loginLoc.logInButton);
        assertMeth.waitForElementAndAssertThatContains(userData.getValidFullName(), homeLock.helloText, Duration.ofSeconds(20));
    }
}
