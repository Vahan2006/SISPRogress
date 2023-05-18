package Locators;

import Data.UserData;
import org.openqa.selenium.By;

public class HomePageLocators {
    UserData userData = new UserData();
    public By helloText = By.xpath("//android.view.View[contains(@content-desc, 'Good')]");

}
