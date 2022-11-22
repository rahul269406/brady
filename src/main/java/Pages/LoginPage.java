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



	@FindBy(xpath = "//*[@class='tv-main']/div[3]/div[2]/div[3]/button[2]")
	WebElement userIcon;

	@FindBy(xpath = "//*[@class='tv-main']/div[3]/div[2]/div[3]/button[1]")
	WebElement signInIcon;
	@FindBy(xpath = "//*[contains(text(), 'Sign in')]")
	WebElement signIn;

	@FindBy(xpath = "//*[contains(text(), 'Email')]")
	WebElement emailButton;

	@FindBy(name = "username")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//*[@id='button-basic']")
	WebElement profileBtn;

	@FindBy(xpath = "//*[text()='rahul269406']")
	WebElement profileEmail;

	@FindBy(xpath = "//*[contains(text(), 'Sign Out')]")
	WebElement signOut;


	public void clickSingInIcon()  {

		signInIcon.click();

		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	public void clickSingIn()  {

		signIn.click();

		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public void clickEmailButton(){
		emailButton.click();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public void sendUserName(String uname) {

		email.sendKeys(uname);
	}
	public void sendPassword(String pwd) {

		password.sendKeys(pwd);
	}
	public void clickSubmit() {

		signInBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public void clickUserIcon(){
		userIcon.click();
	}

	public boolean verifyUserLoggedIn(String enterUname) {

		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String userNameUI=profileEmail.getText();
		if(userNameUI.equalsIgnoreCase(enterUname)){
			return true;
		}
		else{
			return false;
		}
	}

	public void clickSingOut()  {

		signOut.click();

		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}




}
