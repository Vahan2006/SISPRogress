package Methods;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralMethods {
    AndroidDriver driver;
    public GeneralMethods(AndroidDriver driver){
     this.driver = driver;
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void type(String fullName,By locator){
        WebElement element = driver.findElement(locator);
        element.click();
        element.sendKeys(fullName);
    }

    public void scrollFromTo(int fromX, int fromY, int toX, int toY){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(fromX,fromY))
                .moveTo(PointOption.point(toX, toY))
                .release()
                .perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickByCoordinate(int x, int y){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(x,y)).perform();
    }
    public void closeKeyboard(){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(154, 3020));
    }
    public void selectFromFancyDropdown(By dropdown, By option){
        try {
        Thread.sleep(1000);
        } catch (InterruptedException e) {
        throw new RuntimeException(e);
        }
        click(dropdown);
        click(option);
    }
}
