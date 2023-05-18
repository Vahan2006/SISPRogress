package Base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class SetUp {
        private AndroidDriver driver;
    public AndroidDriver setUp(){
        String filePath = null;
        try {
            URL resourceUrl = getClass().getClassLoader().getResource("app.apk");
            if (resourceUrl != null) {
                filePath = Paths.get(resourceUrl.toURI()).toFile().getAbsolutePath();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println(filePath);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app",  filePath);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", true);
//        capabilities.setCapability("appPackage", "com.sp.sis_progress");
//        capabilities.setCapability("appActivity", "com.sp.sis_progress.MainActivity ");
        capabilities.setCapability("newCommandTimeout", "120000");
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (Exception e) {
            System.out.println(e);
        }
        return driver;
    }
}
