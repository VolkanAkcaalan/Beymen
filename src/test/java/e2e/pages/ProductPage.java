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

public class ProductPage extends CommonMethods {

    public ProductPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public static WebDriverWait wait;

    @FindBy(xpath = "//div[@id='productList']// div[@data-page='1'][1]")
    private WebElement firstProduct;


    public String getCurrentLink() {
        return driver.getCurrentUrl();
    }

    public void setFirstProduct() {
        firstProduct.click();
    }



}
