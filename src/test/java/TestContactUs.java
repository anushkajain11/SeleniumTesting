import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestContactUs {
	WebDriver driver;
	@BeforeClass
	  public void setup() {
		 
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.get("http://automationpractice.com/index.php");
		  driver.manage().window().maximize();
	  }
	@Test
	public void testContactUsFlow() throws InterruptedException{
		driver.findElement(By.xpath(".//*[@id='contact-link']/a")).click();
		Assert.assertTrue(driver.getPageSource().contains("Customer service - Contact us"));
		Select dropdown = new Select(driver.findElement(By.id("id_contact")));
		dropdown.selectByValue("2");
		driver.findElement(By.id("email")).sendKeys("testdemo@gmail.com");
		driver.findElement(By.name("message")).sendKeys("Lorem Ipsum for testing");
		driver.findElement(By.id("submitMessage")).click();
		//Thread.sleep(2000);
		Assert.assertTrue(driver.getPageSource().contains("Your message has been successfully sent to our team."));
		Thread.sleep(2000);
	}
	
	 @AfterClass
	  public void tearDown(){
		  driver.close();
	  }
}
