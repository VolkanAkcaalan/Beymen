package e2e.stepDefinitions;

import e2e.utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks extends CommonMethods {


       @Before
       public void initialize () throws IOException {
           openAndLunchApplication();
       }
       @After
       public void tearDown () {
              closeBrowser();
       }
}
