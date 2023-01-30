package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    public WebDriver driver;
    WebDriverWait wait;

    @FindBys(@FindBy(xpath = "//a[@class='list-group-item']"))
    List<WebElement> listCategory;

    @FindBys(@FindBy(xpath = "//h4[@class='card-title']"))
    List<WebElement> listProducts;

    @FindBy(xpath = "//h2[@class='name']")
    WebElement productTitle;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement addCartBtn;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void selectCategory(String category){
        wait.until(ExpectedConditions.visibilityOfAllElements(listCategory));

        for (int i = 0; i<listCategory.size(); i++){
            String itemFromCategoriesList = listCategory.get(i).getText();

            if (itemFromCategoriesList.equals(category)) {
                listCategory.get(i).click();
                break;
            }
        }
    }

    public void selectProduct(String product){
        wait.until(ExpectedConditions.visibilityOfAllElements(listProducts));

        for (int i = 0; i<listProducts.size(); i++){
            String itemFromProductList = listProducts.get(i).getText();

            if (itemFromProductList.equals(product)) {
                listProducts.get(i).click();
                break;
            }
        }
    }

    public String getProductTitle(){
        wait.until(ExpectedConditions.visibilityOf(productTitle));

        return productTitle.getText();
    }

    public void selectAddToCartBtn(){
        wait.until(ExpectedConditions.visibilityOf(addCartBtn));

        addCartBtn.click();
    }

    public String getMessageAlert(){
        wait.until(ExpectedConditions.alertIsPresent());

        return driver.switchTo().alert().getText();
    }

    public void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }


}
