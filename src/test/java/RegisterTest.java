import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest {
	WebDriver driver;
	  @BeforeClass
	  public void setup() {
		 
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.get("http://automationpractice.com/index.php");
		  driver.manage().window().maximize();
	  }
	  
	  @Test(priority=0)
	  public void testVerifyPageTitle(){
		  String title = driver.getTitle();
		  Assert.assertTrue(title.equals("My Store"));
	  }
	  
	  @Test(priority=1)
	  public void testRegister() throws InterruptedException{
		  driver.findElement(By.className("login")).click();
		  String title = driver.getTitle();
		  Assert.assertTrue(title.equals("Login - My Store"));
		  driver.findElement(By.id("email_create")).sendKeys("testdemo1@gmail.com");
		  driver.findElement(By.id("SubmitCreate")).click();
		  Thread.sleep(2000);
		  boolean val1 = driver.getPageSource().contains("Your personal information");
		  Assert.assertTrue(val1);
		  driver.findElement(By.name("customer_firstname")).sendKeys("Test");
		  driver.findElement(By.id("customer_lastname")).sendKeys("Demo");
		  driver.findElement(By.id("passwd")).sendKeys("test12345");
		  driver.findElement(By.id("address1")).sendKeys("123 ABC");
		  driver.findElement(By.name("city")).sendKeys("Santa Clara");
		  Select dropdown = new Select(driver.findElement(By.id("id_state")));
		  dropdown.selectByVisibleText("California");
		  driver.findElement(By.id("postcode")).sendKeys("12345");
		  driver.findElement(By.name("phone_mobile")).sendKeys("0123456789");
		  driver.findElement(By.id("submitAccount")).click();
		  boolean val2 = driver.getPageSource().contains("Welcome to your account. Here you can manage all of your personal information and orders.");
		  Assert.assertTrue(val2);
		  Thread.sleep(2000);
		  
	  }
	  
	  @AfterClass
	  public void tearDown(){
		  driver.close();
	  }
	  
}
