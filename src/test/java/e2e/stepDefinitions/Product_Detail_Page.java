package e2e.stepDefinitions;

import e2e.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Product_Detail_Page extends CommonMethods {



    @Then("User adds selected product to cart")
    public void userAddsSelectedProductToCart() {

        productDetailPage.setFirstSize();

    }

    @And("User verifies the price of the product on both Product Detail Page and Cart Page")
    public void userVerifiesThePriceOfTheProductOnBothProductDetailPageAndCartPage() {
        // Product Detail
        String productPrice = productDetailPage.getProductPrice();
        System.out.println("Product Price: " + productPrice);


        productDetailPage.setAddProduct();


        productDetailPage.clickMyCart();

        getWait();

        // Cart Page
        String cartPrice = cartPage.getProductPriceOfCart();
        System.out.println("Cart Price: " + cartPrice);

        Assert.assertEquals(cartPrice,productPrice);

    }

}
