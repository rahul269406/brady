package Pages;

import Base.TestBase;
import Utilities.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//header//a[@title='Discover your dream Career']")
	WebElement logo;

	@FindBy(xpath = "//*[@id='cmpwelcomebtnyes']/a")
	WebElement AlertBox;


	public boolean isLogoDisplayed() {

		return logo.isDisplayed();
	}
	public void acceptAlert() {
		if(AlertBox.isDisplayed()) {
			AlertBox.click();
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		}
	}




}
