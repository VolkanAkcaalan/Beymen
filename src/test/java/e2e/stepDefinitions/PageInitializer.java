package e2e.stepDefinitions;

import e2e.pages.*;
import io.cucumber.java.an.Dada;

import java.io.IOException;

public class PageInitializer {

    public static ProductPage productPage;
    public static HomePage homePage;

    public static ProductDetailPage productDetailPage;

    public static CartPage cartPage;




    public static void initializeObjects() throws IOException {
        productPage=new ProductPage();
        homePage=new HomePage();
        productDetailPage= new ProductDetailPage();
        cartPage=new CartPage();
    }
}
