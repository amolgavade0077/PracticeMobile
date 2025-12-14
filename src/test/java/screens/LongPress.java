package screens;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
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
//    private WebElement Adapter;
//    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"People Names\")")
    WebElement People;
    public void longPress() {
        WaitToElementAppear(view);
        view.click();
        Expandable.click();
        Adapter.click();
        longPress(People,2000);
        Assert.assertEquals((SampleMenu.getText()),"Sample menu");
        Assert.assertTrue((SampleMenu).isDisplayed());
        String value=SampleMenu.getText();
        System.out.println(value);

    }
}
