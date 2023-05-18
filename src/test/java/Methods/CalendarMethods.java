package Methods;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.ous.jtoml.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarMethods {
    AndroidDriver driver;
    public CalendarMethods(AndroidDriver driver){
        this.driver = driver;
    }
    public void clickTodayCalendar(){
        try {
            String currentDate = driver.getDeviceTime();
            DateFormat formatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
            String formattedDate = formatter.format(currentDate);
            By vardan = By.xpath("//android.view.View[@content-desc=\""+formattedDate+"\"]");
            driver.findElement(vardan).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
