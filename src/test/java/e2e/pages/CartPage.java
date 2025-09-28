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

public class CartPage extends CommonMethods{

    public CartPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public static WebDriverWait wait;




    @FindBy(xpath = "//div[@class='priceBox__priceWrapper -end']")
    private WebElement priceOfTheCart;

    @FindBy(id = "quantitySelect0-key-0")
    private WebElement quantityDropdown;

    @FindBy(id = "removeCartItemBtn0-key-0")
    private WebElement removeCartItem;

    @FindBy(id = "emtyCart")
    private WebElement emptyCart;




    public String  getProductPriceOfCart() {
        return priceOfTheCart.getText().replace(",00 TL","").trim();
    }

    public void selectQuantity(int value) {
        Select quantitySelect = new Select(quantityDropdown);
        quantitySelect.selectByValue(String.valueOf(value));
    }
    public String getSelectedQuantity() {
        Select select = new Select(quantityDropdown);
        String selectedText = select.getFirstSelectedOption().getText();
        System.out.println("Selected Quantity (text): " + selectedText);
        return selectedText;
    }

    public void remoTheItem() {
        removeCartItem.click();
    }

    public String getEmptyCart() {

        return emptyCart.getText();
    }

}
