package screens;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Logger;

public class Forpage extends Utilitys{
    private AppiumDriver driver;
    Logger logger = Logger.getLogger(String.valueOf(Forpage.class));
    public Forpage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Forms\"]")
    private WebElement Forms;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Form components\"]")
    private WebElement FormpageLanding;

    @AndroidFindBy(accessibility = "text-input")
    private WebElement input_field;
    @AndroidFindBy(accessibility = "input-text-result")
    private WebElement input_field_result;

    @AndroidFindBy(accessibility = "switch-text")
    private WebElement Switch_Toggle;

    @AndroidFindBy(accessibility = "switch")
    private WebElement Switch;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"text_input\")")
    private WebElement Dropdown;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Appium is awesome\")")
    private WebElement Dropdown_Value;


    public void fromfillpage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(Forms));
        Forms.click();
        WaitToElementAppear(FormpageLanding);
        String str = FormpageLanding.getText();
        System.out.println(str);
        Assert.assertEquals(str, "Form components", "String match");

    }
    public void fillForm() throws InterruptedException {
        WaitToElementAppear(input_field);
        input_field.sendKeys("Amol Gavade");
        String rsult=input_field_result.getAttribute("text");
        System.out.println(rsult);
        Assert.assertEquals(rsult, "Amol Gavade", "String match");
        Thread.sleep(3000);
    }

    public void VerifyToggle() throws InterruptedException {
        WaitToElementAppear(Switch);
        String BeforeToggleClickSwitchtext=Switch_Toggle.getAttribute("text");
        System.out.println(BeforeToggleClickSwitchtext);

        if (BeforeToggleClickSwitchtext.equalsIgnoreCase("Click to turn the switch ON"))
        {
            Switch.click();
            String afterToggleClickSwitchtext=Switch_Toggle.getAttribute("text");
            System.out.println(afterToggleClickSwitchtext+ " Toggle is Off");
        }

    }

    public void DropdrownSelect () throws InterruptedException {
       Dropdown.click();
       Thread.sleep(3000);
        Dropdown_Value.click();
driver.findElement(AppiumBy.accessibilityId("View")).click();
    }






















}






