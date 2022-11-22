package Pages;

import Base.TestBase;
import Utilities.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AsiaPage extends TestBase {

	public AsiaPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Asia']")
	WebElement asia;

	@FindBy(xpath = "//*[@id='js-screener-container']/div[3]/table/thead/tr/th[1]/div/div/div[3]/input")
	WebElement searchBox;


	@FindAll(
			@FindBy(xpath = "//*[@id='js-screener-container']/div[4]/table/tbody/tr/td[1]/div/div[2]/a")

	)
	private List<WebElement> tableRows;

	public List<WebElement> getMultipleTableRows() {

		return tableRows;
	}

	public void clickAsiaTab() {

		asia.click();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	public void sendValueToSearchBox(String value){
		searchBox.sendKeys(value);

	}





}
