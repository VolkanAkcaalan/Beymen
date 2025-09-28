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

public class HomePage extends CommonMethods {


    public HomePage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public static WebDriverWait wait;

    String filePath = "Keywords.xlsx";
    String searchItem = ExcelReader.getSearchTerm(filePath, 1);
    String searchItem1 = ExcelReader.getSearchTerm(filePath, 2);

    @FindBy(xpath = "//button[@id='genderManButton']")
    private WebElement genderManButton;

    @FindBy(xpath = "//input[@class='o-header__search--input']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@class='o-header__search--btn']")
    private WebElement searchButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement handler;

    @FindBy(xpath = "//button[@class='o-header__search--close -hasButton']")
    private WebElement clearAction;

    @FindBy(xpath = "//a[@class='o-header__userInfo--item bwi-cart-o -cart']")
    private WebElement myCart;

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public String getHomePageLink() {
        return driver.getCurrentUrl();
    }

    public void clickGenderManButton() {
        genderManButton.click();
    }
    public void sendSearchBox() {

        //Cookie Handler
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(handler));
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found or already handled.");
        }
        // Wait for and click the gender selection button
        WebElement genderButton = wait.until(ExpectedConditions.elementToBeClickable(genderManButton));
        genderManButton.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='o-header__search--input']")));
        searchBox.sendKeys(searchItem);
    }
    public void removeTypedKey() {
        clearAction.click();
    }
    public void sendSearchBox1() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("o-searchSuggestion__input")));
        searchBox.sendKeys(searchItem1);
        searchButton.sendKeys(Keys.ENTER);
    }

}


