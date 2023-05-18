package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AssertMethods  {
    WebDriver driver;
    public AssertMethods(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementAndAssertThatContains(String text, By locator, Duration waitTime){
        WebElement element = driver.findElement(locator);
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.attributeContains(element, "content-desc" , text));
        System.out.println(element.getAttribute("content-desc"));
        Assert.assertTrue(element.getAttribute("content-desc").contains(text) , "Username is wrong");
    }

    public void assertThatElementExists(By locator, String message){
        boolean elementExist = driver.findElement(locator).isDisplayed();
        Assert.assertTrue(elementExist, message);
    }
}
