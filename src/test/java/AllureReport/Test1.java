package AllureReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})
public class Test1 extends BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		BaseClass bs = new BaseClass();
		driver = bs.initialize_driver();
		driver.get("https://magento.softwaretestingboard.com/");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1, description="Verify logo presence on Home page")
	@Description("Verify logo presence on Home page")
	@Epic("EP001")
	@Feature("Feature1:Logo")
	@Story("Story:Logo presence")
	@Step("Verify logo presence")
	public void logoPresence() throws InterruptedException {
		boolean dispStatus= driver.findElement(By.cssSelector("a[class='logo']")).isDisplayed();
		Assert.assertEquals(dispStatus, true);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	@Description("Verify registration on Home page")
	@Epic("EP001")
	@Feature("Feature1:Login")
	@Story("Story:Valid registration")
	@Step("Verify login")
	public void registrationTest() throws InterruptedException  {
		driver.findElement(By.linkText("Create an Account")).click();
		driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys("Poor");
		driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys("A");
		driver.findElement(By.xpath("//input[@type='email' and @id='email_address']")).sendKeys("adb@gmail.com");
		driver.findElement(By.xpath("//input[@type='password' and @id='password']")).sendKeys("Adcd@3456");
		driver.findElement(By.xpath("//input[@type='password' and @id='password-confirmation']")).sendKeys("Adcd@3456");
		driver.findElement(By.linkText("Create an Account")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");  
	} 
	
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	@Description("Verify registration on Home page")
	@Epic("EP001")
	@Feature("Feature1:Login")
	@Story("Story:Valid login")
	public void loginTest() {
		throw new SkipException("Skipping this Test");
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	@Description("Verify product on Home page")
	@Epic("EP001")
	@Feature("Feature1:Login")
	@Story("Story:Products")
	public void productTest() {
		driver.findElement(By.cssSelector("a[title='Fusion Backpack']")).click();
		driver.findElement(By.cssSelector("button[title='Add to Cart']")).click();
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
