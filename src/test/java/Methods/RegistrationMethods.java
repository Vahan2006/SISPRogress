package Methods;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class RegistrationMethods {
    private AndroidDriver driver;
    public RegistrationMethods(AndroidDriver driver){
        this.driver = driver;
    }

    public void selectDate(By fieldLocator, By monthArrow, By month, By yearArrow, By year, By day){
        GeneralMethods genMeth = new GeneralMethods(driver);
        TouchAction touchAction = new TouchAction(driver);
        WebElement element = driver.findElement(fieldLocator);
        Point elementPoint = element.getLocation();
        int x =elementPoint.x+1080;
        int y = elementPoint.y+105;
        touchAction.tap(PointOption.point(x,y )).perform();
        genMeth.click(monthArrow);
        genMeth.click(month);
        genMeth.click(yearArrow);
        genMeth.click(year);
        genMeth.click(day);
   }
}
