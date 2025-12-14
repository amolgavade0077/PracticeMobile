package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.Platform;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

public class BaseTest extends AbstractTestNGCucumberTests {
    String platformName;
    String envName;
    private AppiumDriverLocalService service;
    protected static AppiumDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void initializeAppiumServiceURL() {
        service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .usingAnyFreePort()
                        .withTimeout(Duration.ofSeconds(60)));

    }
    @BeforeMethod()
    @Parameters({"platformName", "envName"})
    public void setup(@Optional String _platform, @Optional String _envName) throws MalformedURLException {
        platformName = _platform;
        envName = _envName;
        System.out.println("Test Script is been executed on the following platform: " + platformName + " and Env name is:" + envName);
        System.setProperty("targetOS", platformName);
        System.setProperty("envName", envName);

        if (platformName.equalsIgnoreCase("ios"))
            startAppiumServiceForIos();
        else if (platformName.equalsIgnoreCase("android"))
            startAppiumServerForAndroid();
    }


    private void startAppiumServerForAndroid() throws MalformedURLException {
        String appPackage = "";
        String androidAppPath = "";
       if (Objects.equals(envName, "preprod")) {
            //appPackage = "racv.mobility.tripgo.preprod";
            androidAppPath = "src/test/resources/app/ApiDemos-debug.apk";
        }

        UiAutomator2Options androidOptions = new UiAutomator2Options()
                .setPlatformName(Platform.ANDROID.name())
                .setPlatformVersion("14")
                .setDeviceName("Pixel_5")
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setUdid("emulator-5554")
                .setAvdArgs("-no-audio")
                .clearSystemFiles()
                //.noReset()
                .setAppPackage(appPackage)
                //.setAppActivity("racv.mobility.tripgo.presentation.MainActivity")
                .setApp(androidAppPath);

        driver = new AndroidDriver(service, androidOptions);
    }

     @BeforeTest(alwaysRun = true)
    private void startAppiumServiceForIos() {
        String bundleId = "";
        String iOSAppPath = "";
        if (Objects.equals(envName, "staging")) {
            bundleId = "com.intelematics.maas.arevo.staging";
            iOSAppPath = "src/test/resources/app/Arevo_staging.app";
        } else if (Objects.equals(envName, "preprod")) {
            bundleId = "au.com.racv.arevo.staging";
            iOSAppPath = "src/test/resources/app/Arevo_preprod.app";
        } else if (Objects.equals(envName, "prod")) {
            bundleId = "au.com.racv.arevo";
            iOSAppPath = "src/test/resources/app/Arevo_prod.app";
        }
        service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .usingAnyFreePort()
                        .withTimeout(Duration.ofSeconds(60)));
        XCUITestOptions iosOptions = new XCUITestOptions()
                .setPlatformName(Platform.IOS.name())
                .setPlatformVersion("18.2")
                .setDeviceName("iPhone 16 Plus")
                .setAutomationName(AutomationName.IOS_XCUI_TEST)
                .setBundleId(bundleId)
                .setApp(iOSAppPath)
                .clearSystemFiles();
        //.showXcodeLog();
        //.noReset();

        driver = new IOSDriver(service, iosOptions);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("AfterClass:--");
        if (driver != null)
            driver.quit();
    }

}