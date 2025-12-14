package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import runner.BaseTest;
import screens.Forpage;
import screens.LongPress;
import screens.Utilitys;

import static org.testng.Assert.assertTrue;

public class Step_defi extends BaseTest {


    Forpage formPage;
    LongPress longpress;
    Utilitys utils;
    @Given("the user is want to fill the from")
    public void the_user_is_want_to_fill_the_from() {
        formPage = new Forpage(driver);
        formPage.fromfillpage();
    }

    @Then("user enter the Input field and verify the input field result")
    public void user_enter_the_input_field_and_verify_the_input_field_result() throws InterruptedException {
        formPage.fillForm();
    }

    @And("select toggle ON_OFF")
    public void select_toggle_ON_OFF() throws InterruptedException {
        formPage.VerifyToggle();
    }

    @And("select dropDown")
    public void select_DropDown() throws InterruptedException {
        formPage.DropdrownSelect();
    }


    @And("handel Gestures")
    public void handel_gestures() throws InterruptedException {
        longpress = new LongPress(driver);
        longpress.longPress();



    }









}
