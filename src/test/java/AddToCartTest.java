import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartTest {
WebDriver driver;
	
	@BeforeClass
	  public void setup() {
		 
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.get("http://automationpractice.com/index.php");
		  driver.manage().window().maximize();
	  }
	@Test(priority =0)
	public void testSelectAnItem() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		WebElement itemToBuy = driver.findElement(By.cssSelector("li>div.product-container>div>div>a[title='Faded Short Sleeve T-shirts']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(itemToBuy).build().perform();
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li>div.product-container>div>div>a[title='Faded Short Sleeve T-shirts']")));
		driver.findElement(By.cssSelector("li>div.product-container>div>div>a[title='Faded Short Sleeve T-shirts']")).click();
		Assert.assertTrue(driver.getTitle().equals("Faded Short Sleeve T-shirts - My Store"));
		Thread.sleep(5000);
	}
	
	@Test(priority =1)
	public void testCheckDetailsAndBuy() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,650)", "");
		driver.findElement(By.id("thumb_2")).click();
		driver.findElement(By.cssSelector(".fancybox-item.fancybox-close")).click();
		jse.executeScript("window.scrollBy(0,-500)", "");
		Select size = new Select(driver.findElement(By.id("group_1")));
		size.selectByVisibleText("L");
		driver.findElement(By.className("exclusive")).click();
		
		Thread.sleep(5000);
	}
	
	 @AfterClass
	 public void tearDown(){
		 driver.close();
	 }
}
