package e2e.stepDefinitions;

import e2e.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Home_Page extends CommonMethods {


    @Given("User navigates to website and verify title as {string} and current link as {string}")
    public void userNavigatesToWebsiteAndVerifyTitleAsAndCurrentLinkAs(String expectTitle, String expectLink) {
        Assert.assertEquals(expectTitle,homePage.getHomePageTitle());
        Assert.assertEquals(expectLink,homePage.getHomePageLink());
    }

    @When("User type a product name and then removes it")
    public void userTypeAProductNameAndThenRemovesIt() {
        homePage.sendSearchBox();
        homePage.removeTypedKey();
    }
    @Then("User type another product name and then enter with keyboard key")
    public void userTypeAnotherProductNameAndThenEnterWithKeyboardKey() {
        homePage.sendSearchBox1();
    }









}
