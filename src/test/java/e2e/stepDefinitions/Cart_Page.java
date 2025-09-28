package e2e.stepDefinitions;

import e2e.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Cart_Page extends CommonMethods {

    @When("User switch to two quantities of the selected product as {int}")
    public void userSwitchToTwoQuantitiesOfTheSelectedProductAs(int quantity) {
        cartPage.selectQuantity(quantity);
        Assert.assertEquals("2 adet",cartPage.getSelectedQuantity());
    }

    @Then("User removes the product from cart page")
    public void userRemovesTheProductFromCartPage() {
        cartPage.remoTheItem();
    }

    @And("User verifies cart page is empty")
    public void userVerifiesCartPageIsEmpty() {
        Assert.assertEquals("SEPETINIZDE ÜRÜN BULUNMAMAKTADIR\n" +
                "Birbirinden seçkin markaların, binlerce ürününü hemen keşfedin\n" +
                "ALIŞVERIŞE BAŞLA",cartPage.getEmptyCart());
    }
}
