package Utilities;

import Pages.AsiaPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.xml.bind.Element;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestUtils {

	static DateFormat dateFormat;
	static Date date;

	public static final long PAGE_LOAD_TIMEOUT = 100;

	public static final long IMPLICIT_WAIT = 10;

	// provide path of workspace from your local machine
	public static final String WORKSAPCE_PATH = "C://Users//rahul//OneDrive//Desktop//Projects//Demo";

	public static final String SCREENSHOT_PATH = WORKSAPCE_PATH + "//Screenshot//";

	public static final String DateFormat = "yyyyMMddHH-mm-ss";

	public static String getDate(String format) {
		dateFormat = new SimpleDateFormat(format);
		date = new Date();
		return dateFormat.format(date);
	}

	public static void takeScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(SCREENSHOT_PATH + "//screenshot//" + getDate(DateFormat) + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static String findLastExchange(WebDriver driver, String arg0) throws InterruptedException {
		String rate = "";
		AsiaPage asiaPage= new AsiaPage();
		List<WebElement> lists = asiaPage.getMultipleTableRows();
		int i=1;
		 for( int j=0;j<= lists.size()-1;j++) {
			 Thread.sleep(3000);
					 String name = lists.get(j).getText();
					 if (name.equalsIgnoreCase(arg0)) {
						 rate = driver.findElement(By.xpath("//*[@id='js-screener-container']/div[4]/table/tbody/tr[" + i + "]/td[2]")).getText();
						 System.out.println(rate);
						 break;
					 }
					 i++;

		 }
return rate;
		}

}
