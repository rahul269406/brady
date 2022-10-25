package Pages;

import Base.TestBase;
import Utilities.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(), 'Sign in / Register')]")
	WebElement signIn;

	@FindBy(xpath = "//input[@type='text']")
	WebElement email;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//*[@id='button-basic']")
	WebElement profileBtn;

	@FindBy(xpath = "//*[@id='dropdown-avatar-container']/div/span")
	WebElement profileEmail;

	public void clickSingIn()  {

		signIn.click();

		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public void sendUserName(String uname) {

		email.sendKeys(uname);
	}
	public void sendPassword(String pwd) {

		password.sendKeys(pwd);
	}
	public void clickContinue() {

		continueBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	public void clickSubmit() {

		submitBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public boolean verifyUserLoggedIn(String enterUname) {

		profileBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String userNameUI=profileEmail.getText();
		if(userNameUI.equalsIgnoreCase(enterUname)){
			return true;
		}
		else{
			return false;
		}
	}




}
