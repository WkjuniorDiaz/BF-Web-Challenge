package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "login2")
    WebElement logInMenuOption;

    @FindBy(id = "logInModalLabel")
    WebElement logInModalTitle;

    @FindBy(id = "loginusername")
    WebElement usernameField;

    @FindBy(id = "loginpassword")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement logInBtn;

    @FindBy(id = "logout2")
    WebElement logOutMenuOption;

    @FindBy(id = "nameofuser")
    WebElement nameUser;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectLogInMenu(){
        wait.until(ExpectedConditions.visibilityOf(logInMenuOption));
        logInMenuOption.click();
    }

    public String getLogInTitle(){
        wait.until(ExpectedConditions.visibilityOf(logInModalTitle));

        return logInModalTitle.getText();
    }

    public void setUsername(String username){
        usernameField.sendKeys(username);
    }

    public void setPassword(String password){
        passwordField.sendKeys(password);
    }

    public void selectLogInBtn(){
        wait.until(ExpectedConditions.visibilityOf(logInBtn));
        logInBtn.click();
    }

    public void selectLogOutMenu(){
        wait.until(ExpectedConditions.visibilityOf(nameUser));

        logOutMenuOption.click();
    }

    public String getLogInMenuOption(){
        wait.until(ExpectedConditions.visibilityOf(logInMenuOption));

        return logInMenuOption.getText();
    }

    public String getLogOutMenuOption(){
        wait.until(ExpectedConditions.visibilityOf(logOutMenuOption));

        return logOutMenuOption.getText();
    }





}
