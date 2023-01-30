package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class LoginStepDefinition {
    TestContextSetup testContextSetup;
    LoginPage loginPage;

    public LoginStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        loginPage = testContextSetup.pageObjectManager.getLoginPage();
    }

    @When("user select Log in from Menu bar")
    public void user_select_log_in_from_menu_bar(){
        loginPage.selectLogInMenu();
        Assert.assertEquals("Log in title in modal is not displayed","Log in",loginPage.getLogInTitle());
    }

    @And("type same username {string}")
    public void type_same_username(String username){
        loginPage.setUsername(username);
    }

    @And("type same password {string}")
    public void type_same_password(String password){
        loginPage.setPassword(password);
    }

    @And("select Log in button")
    public void select_log_in_button(){
        loginPage.selectLogInBtn();
    }

    @And("select Log out from menu bar")
    public void select_log_out_from_menu_bar(){
        loginPage.selectLogOutMenu();
    }

    @Then("verify user is log into product store")
    public void verify_user_is_log_into_product_store(){
        Assert.assertEquals("Log out",loginPage.getLogOutMenuOption());
    }

    @Then("verify user is log out from product store")
    public void verify_user_is_log_out_from_product_store(){
        Assert.assertEquals("Log in",loginPage.getLogInMenuOption());
    }





}
