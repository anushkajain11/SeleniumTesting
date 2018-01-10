import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScollUpAndDownTest {
	WebDriver driver;
	
	@BeforeClass
	  public void setup() {
		 
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.get("http://automationpractice.com/index.php");
		  driver.manage().window().maximize();
	  }
	
	@Test
	public void testScrollUpAndDown() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Scroll down 
		jse.executeScript("window.scrollBy(0,650)", "");
		Thread.sleep(5000);
		//Scroll up
		jse.executeScript("window.scrollBy(0,-250)", "");
		
	}
	
	
	 @AfterClass
	 public void tearDown(){
		 driver.close();
	 }
}

