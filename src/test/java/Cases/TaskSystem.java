package Cases;

import Base.LogIn;
import Base.SetUp;
import Locators.BottomMenuLocators;
import Locators.CalendarLocators;
import Methods.CalendarMethods;
import Methods.GeneralMethods;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TaskSystem {
    private static AndroidDriver driver;

    @BeforeSuite
    public void setUp() {
        SetUp setUp = new SetUp();
        driver = setUp.setUp();
        LogIn login = new LogIn(driver);
    }

    @AfterMethod
    public void afterEach() {
        String appPkg = driver.getCurrentPackage();
        driver.terminateApp(appPkg);
        driver.activateApp(appPkg);
    }

    @Test
    public void addTaskFromCalendarAndAssert(){
        BottomMenuLocators menuLoc = new BottomMenuLocators();
        GeneralMethods genMeth = new GeneralMethods(driver);
        CalendarLocators calLoc = new CalendarLocators();
        genMeth.click(menuLoc.calendar);
        genMeth.click(calLoc.addTask);

    }
}
