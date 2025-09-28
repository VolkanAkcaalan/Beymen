package e2e.stepDefinitions;

import e2e.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Product_Page extends CommonMethods {

    @Then("User verifies current link as {string}")
    public void userVerifiesCurrentLinkAs(String expectedCurrentLink) {
        Assert.assertEquals(expectedCurrentLink,productPage.getCurrentLink());


    }

    @And("User clicks first product on the page and verifies product page")
    public void userClicksFirstProductOnThePageAndVerifiesProductPage() {
        productPage.setFirstProduct();
    }
}
