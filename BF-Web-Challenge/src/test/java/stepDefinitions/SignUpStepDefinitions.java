package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.SignUpPage;
import utils.TestContextSetup;

public class SignUpStepDefinitions {
    TestContextSetup testContextSetup;
    SignUpPage signUpPage;

    public SignUpStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        signUpPage = testContextSetup.pageObjectManager.getSignUpPage();
    }

    @When("user select Sign up from menu bar")
    public void user_select_sign_up_from_menu_bar(){
        signUpPage.selectSignUpMenu();
        Assert.assertEquals("Sign up",signUpPage.getSignUpModalTitle());
    }

    @And("type username {string}")
    public void type_username(String username){
        signUpPage.setUsername(username);
    }

    @And("type password {string}")
    public void type_password(String password){
        signUpPage.setPassword(password);
    }

    @And("select Sign Up button")
    public void select_sign_up_button(){
        signUpPage.selectSignUpBtn();
    }

    @Then("verify confirmation message {string} displayed")
    public void verify_confirmation_message_displayed(String message){
        Assert.assertEquals("Confirmation message is not displayed",message,signUpPage.getConfirmationMessage());
        signUpPage.acceptAlert();
    }

    @Given("user sign up to Product Store with username {string} and password {string}")
    public void user_sign_up_to_product_store_with_username_and_password(String username, String password){
        signUpPage.signUp(username,password);
    }
}
