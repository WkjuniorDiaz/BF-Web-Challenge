package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    public SignUpPage signUpPage;
    public LoginPage loginPage;
    public ProductPage productPage;
    public CartPage cartPage;



    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public SignUpPage getSignUpPage(){
        signUpPage = new SignUpPage(driver);
        return signUpPage;
    }

    public LoginPage getLoginPage(){
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public ProductPage getProductPage(){
        productPage = new ProductPage(driver);
        return productPage;
    }

    public CartPage getCartPage(){
        cartPage = new CartPage(driver);
        return  cartPage;
    }


}
