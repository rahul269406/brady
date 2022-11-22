package StepDefinitions;



import Base.TestBase;
import Pages.AsiaPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

public class MyStepdefs extends TestBase {

    public static String enteredEmail;

    @Given("^User is on the home page of the application$")
    public void userIsOnTheHomePageOfTheApplication() throws InterruptedException {


        System.out.println("================ started SUITE ================");
        initializaton();
        HomePage homepage = new HomePage();

        homepage.isLogoDisplayed();
        homepage.acceptAlert();

    }

    @When("user click on login Icon")
    public void userClickOnLoginButton()  {
        LoginPage loginPage =new LoginPage();
        loginPage.clickSingInIcon();
        loginPage.clickSingIn();
        loginPage.clickEmailButton();
    }

    @When("^user enter the \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEnterTheAnd(String arg0, String arg1)  {
        // enter username and password details
        enteredEmail=arg0;
        LoginPage loginPage =new LoginPage();
        loginPage.sendUserName(arg0);
        loginPage.sendPassword(arg1);



    }

    @And("^user click on login button$")
    public void userClickOnSignInButton() {
        //click on submit button
        LoginPage loginPage =new LoginPage();
        loginPage.clickSubmit();
    }

    @Then("^verify user is logged in$")
    public void verifyUserIsLoggedIn() {
        //verify that user is has logged in successfully
        LoginPage loginPage =new LoginPage();
        loginPage.clickUserIcon();
        boolean flag=loginPage.verifyUserLoggedIn(enteredEmail);

        Assert.assertTrue(flag, "User is logged in successfully");
    }


    @Then("Close the Browser")
    public void closeTheBrowser() {
        //close the driver
        tearDownMain();
    }

    @When("user click on asia tab")
    public void userClickOnAsiaTab() {
        AsiaPage asiaPage = new AsiaPage();
        asiaPage.clickAsiaTab();
    }

    @When("user search for {string} exchange and Find the last exchange rate")
    public void userSearchForExchangeAndFindTheLastExchangeRate(String arg0) throws InterruptedException {
        AsiaPage asiaPage = new AsiaPage();
        asiaPage.sendValueToSearchBox(arg0);
       String lastExchangeRate= TestUtils.findLastExchange(driver, arg0);
       if(lastExchangeRate.isEmpty()){

           Assert.fail("Not able to find the last exchange rate. Something went wrong");
       }
       else {
           System.out.println("Value of last Exchange rate is "+lastExchangeRate);
           setValueToPropertyFile("OnelastExchangeRates",lastExchangeRate);
       }
    }

    @Then("Sign Out from application")
    public void signOutFromApplication() {
        LoginPage loginPage =new LoginPage();
        loginPage.clickUserIcon();
        loginPage.clickSingOut();
    }


    @When("User find the last three exchange rates for {string}  for a period of one minute")
    public void userFindTheLastThreeExchangeRatesForForAPeriodOfOneMinute(String arg0) throws InterruptedException {
        Set<String> set= new HashSet<>() ;
        while (set.size()<=3) {
           // Thread.sleep(10000);
            String lastExchangeRate = TestUtils.findLastExchange(driver, arg0);
            set.add(lastExchangeRate);
            System.out.println( "Values of last 3 rates"+set);
        }
        setValueToPropertyFile(" lastThreeExchangeRates",set.toString());
    }
}
