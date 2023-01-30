package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "cartur")
    WebElement cartMenuOption;

    @FindBys(@FindBy(xpath = "//tr[@class='success']"))
    List<WebElement> listProductAdded;


    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void selectCartOptionMenu(){
        wait.until(ExpectedConditions.visibilityOf(cartMenuOption));

        cartMenuOption.click();
    }

    public boolean verifyProductIsSaved(String product){
        wait.until(ExpectedConditions.visibilityOfAllElements(listProductAdded));

        boolean wasProductsaved = false;

        for (int i = 0; i<listProductAdded.size(); i++){
            String itemFromProductList = listProductAdded.get(i).getText();

            if (itemFromProductList.contains(product)) {
                wasProductsaved = true;
                break;
            }
        }

        return wasProductsaved;
    }
}
