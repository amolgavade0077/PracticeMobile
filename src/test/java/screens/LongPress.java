package screens;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.logging.Logger;

public class LongPress extends Utilitys {

    private AppiumDriver driver;
    Logger logger = Logger.getLogger(LongPress.class.getName());

    public LongPress(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Views")
    private WebElement view;
    @AndroidFindBy(accessibility = "Expandable Lists")
    private WebElement Expandable;
    @AndroidFindBy(accessibility = "1. Custom Adapter")
    private WebElement Adapter;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]")
    private WebElement SampleMenu;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"People Names\")")
    WebElement People;

    @AndroidFindBy(accessibility = "Gallery")
    private WebElement Gallery;
    @AndroidFindBy(accessibility = "1. Photos")
    private WebElement photo;

    @AndroidFindBy(xpath = "(//android.widget.ImageView)[1]")
    private WebElement firstPhoto;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drag and Drop\")")
    private WebElement DragAndDrop;
    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private WebElement DragElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/drag_result_text\"]")
    private WebElement Droped;


    public void longPress() {
        WaitToElementAppear(view);
        //#LongPress
//        view.click();
//        Expandable.click();
//        Adapter.click();
//        longPress(People,2000);
//        Assert.assertEquals((SampleMenu.getText()),"Sample menu");
//        Assert.assertTrue((SampleMenu).isDisplayed());
// #Scroll Down
//        view.click();
//        scrollDown("WebView");
// #swipe
//        view.click();
//        Gallery.click();
//        photo.click();
//        Assert.assertEquals(firstPhoto.getAttribute("focusable"),"true");
//        SwipeGesture(firstPhoto,"left");
//        Assert.assertEquals(firstPhoto.getAttribute("focusable"),"false");
//#DragAndDrop
        view.click();
        DragAndDrop.click();
        DragAndDrop(DragElement,644,1038);
        Assert.assertEquals(Droped.getAttribute("text"),"Dropped!");


    }
}
