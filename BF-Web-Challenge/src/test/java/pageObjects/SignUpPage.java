package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "signin2")
    WebElement signUpMenu;

    @FindBy(id = "signInModalLabel")
    WebElement signUpModal;

    @FindBy(id = "sign-username")
    WebElement usernameField;

    @FindBy(id = "sign-password")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement signUpBtn;

    public SignUpPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void selectSignUpMenu(){
        signUpMenu.click();
        wait.until(ExpectedConditions.visibilityOf(signUpModal));
    }

    public String getSignUpModalTitle(){
        return signUpModal.getText();
    }

    public void setUsername(String username){
        usernameField.sendKeys(username);
    }

    public void setPassword(String password){
        passwordField.sendKeys(password);
    }

    public void selectSignUpBtn(){
        signUpBtn.click();
    }

    public void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public String getConfirmationMessage(){
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert is: " + driver.switchTo().alert().getText());
        return driver.switchTo().alert().getText();
    }

    public void signUp(String username, String password){
        selectSignUpMenu();
        setUsername(username);
        setPassword(password);
        selectSignUpBtn();
        acceptAlert();
    }
}
