package Locators;

import org.openqa.selenium.By;

public class LogInLocators {
    public By logInButton = By.xpath("//android.widget.Button[@content-desc=\"Log In\"]");
    public By emailField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]");
    public By passwordField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
    public By wrongFormatMailError = By.xpath("//android.view.View[@content-desc=\"Email must be in the correct format\"]");
    public By invalidMailOrPasswordError = By.xpath("//android.view.View[@content-desc=\"Email or password is invalid\"]");
}
