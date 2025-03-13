package org.projeto.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {


    private static WebDriver driverApp = null;


    public static WebDriver inicializarApp() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "/opt/mobile/lojinha-nativa.apk");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        //capabilities.setCapability("appium:connectHardwareKeyboard", true);
        capabilities.setCapability("appium:udid", "127.0.0.1:6555");

        try {

            if (driverApp == null) {
                driverApp = new RemoteWebDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            }

        } catch (MalformedURLException exception) {
            exception.getMessage();
        }
        return driverApp;
    }

    public static WebDriver desativarApp() {
        if (driverApp != null) {
            driverApp.quit();
        }
        return driverApp = null;
    }

}
