package pl.edu.us.SeleniumChallenge;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumScreenshotHelper {
	
	private WebDriver driver;	
	TakesScreenshot screenshottingDriver = (TakesScreenshot)driver;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void takeScreenshot() throws InterruptedException, IOException {		
		driver.get("http://www.anaesthetist.com/mnm/javascript/calc.htm");		
		File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("zrzutEkranu.jpg"));
	}
		
}
