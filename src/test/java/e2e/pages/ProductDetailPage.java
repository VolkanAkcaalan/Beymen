package e2e.pages;

import e2e.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import e2e.utils.ExcelReader;

import java.io.IOException;
import java.time.Duration;

public class ProductDetailPage extends CommonMethods{

    public ProductDetailPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public static WebDriverWait wait;

    @FindBy(xpath = "//div[@class='m-price__lastPrice']")
    private WebElement priceOfTheProduct;

    @FindBy(xpath = "//button[@class='m-notification__button btn']")
    private WebElement goToMyCart;

    @FindBy(xpath = "//span[@class='m-variation__item'][1]")
    private WebElement firstSize;

    @FindBy(id = "addBasket")
    private WebElement addProduct;

    public String getCurrentLink() {
        return driver.getCurrentUrl();}
    public void setFirstSize() {
        firstSize.click();
    }
    public void setAddProduct() {
        addProduct.click();
    }

    public String getProductPrice() {

        return priceOfTheProduct.getText().replace(" TL", "").trim();
    }

    public void clickMyCart() {

        goToMyCart.click();
    }
}
