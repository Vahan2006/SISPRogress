package Cases;

import Data.UserData;
import Locators.RegistrationLocators;
import Methods.GeneralMethods;
import Methods.RegistrationMethods;
import Methods.RequestMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RegistrationSystem {

    private static AndroidDriver driver;
    @BeforeClass
    public void setUp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("appPackage", "com.sp.sis_progress");
        capabilities.setCapability("appActivity", "com.sp.sis_progress.MainActivity ");
        try{
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void RegistrationWithValidData(){
        GeneralMethods genMeth = new GeneralMethods(driver);
        RegistrationLocators regLoc = new RegistrationLocators();
        RegistrationMethods regMeth = new RegistrationMethods(driver);
        UserData ud = new UserData();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        genMeth.click(regLoc.registrationButton);
        genMeth.type(ud.getFullName(), regLoc.fullNameField);
        genMeth.type(ud.getMail(), regLoc.emailField);
        genMeth.type(ud.getPassword(), regLoc.passwordField);
        genMeth.type(ud.getPassword(),regLoc.confirmPasswordField);
        genMeth.scrollFromTo(700,1600, 700, 700);
        genMeth.click(regLoc.countryNumSelector);
        genMeth.click(regLoc.countryNum);
        genMeth.type(ud.getNumber(), regLoc.numberField);
        genMeth.scrollFromTo(700,1600, 700, 700);
        regMeth.selectDate(regLoc.date, regLoc.monthArrow, regLoc.month, regLoc.yearArrow, regLoc.year, regLoc.day);
        genMeth.clickByCoordinate(800,2500);
        genMeth.scrollFromTo(700,1600, 700, 700);
        genMeth.closeKeyboard();
        genMeth.selectFromFancyDropdown(regLoc.countryDropdown, regLoc.country);
        genMeth.selectFromFancyDropdown(regLoc.gradeDropdown, regLoc.grade);
        genMeth.click(regLoc.nextButton);
        genMeth.selectFromFancyDropdown(regLoc.uniDropdown, regLoc.uni);
        genMeth.click(regLoc.termOption);
        genMeth.click(regLoc.admissionOption);
        genMeth.click(regLoc.financialAidOption);
        genMeth.click(regLoc.legacyOption);
        genMeth.click(regLoc.nextButton);
        driver.quit();
    }
}











