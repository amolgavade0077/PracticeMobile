package screens;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class Utilitys {


    private AppiumDriver driver;
    //Logger logger = Logger.getLogger(String.valueOf(Forpage.class));
    public Utilitys(AppiumDriver driver) {
        this.driver = driver;
    }

    public void WaitToElementAppear(WebElement Element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    public void longPress(WebElement ele,int duration)
    {
        ((JavascriptExecutor) driver).executeScript("mobile:longClickGesture",ImmutableMap.of(
                "elementId",((RemoteWebElement)ele).getId(),
                "duration",duration));
    }

    public void scrollDown(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));

    }



    public void SwipeGesture(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile:swipeGesture", ImmutableMap.of("element",
                ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 0.20));
    }

    public void DragAndDrop(WebElement ele,int xCordi,int ycordi)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "endX", xCordi,
                "endY", ycordi));
    }

}
