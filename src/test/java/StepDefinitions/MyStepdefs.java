package StepDefinitions;



import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

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

    @When("user click on login button")
    public void userClickOnLoginButton()  {
        LoginPage loginPage =new LoginPage();
        loginPage.clickSingIn();
    }

    @When("^user enter the \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEnterTheAnd(String arg0, String arg1)  {
        // enter username and password details
        enteredEmail=arg0;
        LoginPage loginPage =new LoginPage();
        loginPage.sendUserName(arg0);
        loginPage.clickContinue();
        loginPage.sendPassword(arg1);



    }

    @And("^user click on submit button$")
    public void userClickOnSubmitButton() {
        //click on submit button
        LoginPage loginPage =new LoginPage();
        loginPage.clickSubmit();
    }

    @Then("^verify user is logged in$")
    public void verifyUserIsLoggedIn() {
        //verify that user is has logged in successfully
        LoginPage loginPage =new LoginPage();
        boolean flag=loginPage.verifyUserLoggedIn(enteredEmail);

        Assert.assertTrue(flag, "User is logged in successfully");
    }


    @Then("Close the Browser")
    public void closeTheBrowser() {
        //close the driver
        tearDownMain();
    }
}
