package utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class Full_Driver {

        private Full_Driver() {
        }

        private static UiAutomator2Options options;
        private static XCUITestOptions iosOptions;

        private static AppiumDriver appiumDriver;
        @Test
        public static AppiumDriver getDriver() {

            if (appiumDriver== null) {
                switch (ConfigReader.getProperty("platformName")) {
                    case "Android":
                        options = new UiAutomator2Options()
                                .setAppPackage("com.nomad.atoumod.staging")
                                .setAppActivity("com.nomad.atoumod.MainActivity")
                                .setDeviceName("Pixel")
                                .setAutomationName("uiautomator2")
                                .setNoReset(false)
                                .setNewCommandTimeout(Duration.ofMinutes(10));

                        try {
                            appiumDriver = new AndroidDriver(
                                    new URL("http://127.0.0.1:4723"), options
                            );
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }

                        break;

                    case "IOS":
                        iosOptions = new XCUITestOptions();
                        iosOptions.XCODE_ORG_ID_OPTION.contains("hakan.tetik@......com");
                        iosOptions.setBundleId("com.atoumod")
                                .setDeviceName("iPhone SE")
                                .setPlatformVersion("16.6")
                                .setUdid("U99693797933")
                                .setAutomationName("XCUITest")
                                .setNoReset(false)
                                .setNewCommandTimeout(Duration.ofMinutes(10));


                        try {
                            appiumDriver = new IOSDriver(
                                    new URL("http://127.0.0.1:4723"), iosOptions
                            );
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                        break;




                }
            }
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return appiumDriver;
        }

        public static void quitDriver() {
            if (appiumDriver != null) {
                appiumDriver.quit();
                appiumDriver = null;

            }



    }
}
