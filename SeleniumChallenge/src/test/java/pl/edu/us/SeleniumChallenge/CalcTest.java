package pl.edu.us.SeleniumChallenge;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalcTest {
	
	private WebDriver driver;	
	
	int multiply(WebDriver driver, int multiplier, int multiplicand) throws InterruptedException {		
		driver.get("http://www.anaesthetist.com/mnm/javascript/calc.htm");
		WebElement searchInput = driver.findElement(By.name("Display"));
		searchInput.sendKeys(String.valueOf(multiplier));
		driver.findElement(By.name("mul")).click();
		searchInput.sendKeys(String.valueOf(multiplicand));
		driver.findElement(By.name("result")).click();		
		return Integer.valueOf(searchInput.getAttribute("value"));
	}	


	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
		
	@Test
	public void calcTest() throws InterruptedException {
		assertEquals(96, multiply(driver, 12, 8));
	}
}
