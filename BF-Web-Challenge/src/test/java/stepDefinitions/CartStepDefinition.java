package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.CartPage;
import pageObjects.ProductPage;
import utils.TestContextSetup;

public class CartStepDefinition {

    TestContextSetup testContextSetup;
    ProductPage productPage;
    CartPage cartPage;

    public CartStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        productPage = testContextSetup.pageObjectManager.getProductPage();
        cartPage  = testContextSetup.pageObjectManager.getCartPage();
    }

    @When("user select the category {string} of the product desire")
    public void user_select_the_category_of_the_product_desire(String category){
        productPage.selectCategory(category);
    }

    @And("select product {string} to be add")
    public void select_product_to_be_add(String product){
        productPage.selectProduct(product);
        Assert.assertEquals(product,productPage.getProductTitle());
    }

    @And("select Add to cart button")
    public void select_add_to_cart_button(){
        productPage.selectAddToCartBtn();
        Assert.assertEquals("Product added",productPage.getMessageAlert());
        productPage.acceptAlert();
    }

    @And("select Cart option from Menu bar")
    public void select_cart_option_from_menu_bar(){
        cartPage.selectCartOptionMenu();
    }

    @Then("verify product {string} was added to list of product")
    public void verify_prouct_was_added_to_list_of_product(String product){
        Assert.assertTrue("Product not found in the list", cartPage.verifyProductIsSaved(product));
    }



}
