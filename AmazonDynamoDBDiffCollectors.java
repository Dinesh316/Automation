package TestPackage;

import java.util.List;
import java.util.function.Function;

//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import org.apache.commons.io.FileUtils;

public class AmazonDynamoDBDiffCollectors {

	public static void main(String[] args) {

		  System.setProperty("webdriver.chrome.driver", "/Users/dinesh/Documents/BrowserDrivers/chromedriver");
		  WebDriver driver = new ChromeDriver();
		  
		//  ChromeOptions chromeOptions = new ChromeOptions();
		//  chromeOptions.addArguments("--kiosk");
		//  driver = new ChromeDriver(chromeOptions);
		  
		  driver.get("https://vr66-dgondhesi");

		  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		  WebElement userName = driver.findElement(By.id("userName-inputEl"));
		  userName.sendKeys("admin");
		  
		  WebElement password = driver.findElement(By.id("password-inputEl"));
		  password.sendKeys("P@ssw0rd1");
		  
		  WebElement loginButton = driver.findElement(By.id("loginBtn-btnInnerEl"));
		  loginButton.click();
		  
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  
		  WebElement searchBox = driver.findElement(By.id("objectNavigatorToolbarHomeDashboardBtn-btnWrap"));
		  if(searchBox.isDisplayed())
		  {
			  System.out.println("Home Page is Displayed");
		  }
		  else
			  {
				 System.out.println("HomePage is not Displayed");
		  }
		  
		  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
		 
		  WebElement navigationLinks = driver.findElement(By.linkText("Administration"));
		  navigationLinks.click();

		  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  

		  WebElement navigationInstance = driver.findElement(By.xpath("//div[normalize-space()='Amazon RDS']"));
		  navigationInstance.click();
try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		  WebElement configurationButton = driver.findElement(By.xpath("//span[contains(@style,'background-image:url(themes/clarity-light/images/app/configure.png)')]"));
		  configurationButton.click();
		  
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  WebElement AccessName = driver.findElement(By.id("textfield-1343-inputEl"));
		  AccessName.clear();
		  AccessName.sendKeys("AKIAIUW4JIRN4GTE7WFA");
		  
		  WebElement region = driver.findElement(By.id("combo-1344-inputEl"));
		  region.clear();
		  region.sendKeys("US East (N. Virginia)");

		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		  WebElement advancedSettings =driver.findElement(By.xpath("//tr[38]/td/table/tbody/tr/td/div"));
		  advancedSettings.click();

			WebElement wait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[1]/td[2]/div/div/div/div[2]")));
			
			WebElement collectorNameArrow=driver.findElement(By.xpath("//tr[1]/td[2]/div/div/div/div[2]"));
			collectorNameArrow.click();
			
			WebElement wait1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='vRealize Operations Manager Collector-vr66-dgondhesi-rc']")));
			
			WebElement collectorNameClick=driver.findElement(By.xpath("//div[normalize-space()='vRealize Operations Manager Collector-vr66-dgondhesi-rc']"));
			collectorNameClick.click();

			
			WebElement wait11 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Test Connection']")));
		  
		  WebElement testConnectionButton = driver.findElement(By.xpath("//a[normalize-space()='Test Connection']"));
		  testConnectionButton.click();
		  
		  try {
				Thread.sleep(10000);	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {

			FileUtils.copyFile(src, new File("/Users/dinesh/Desktop/images/image1"));
			}catch (IOException e) {
				 System.out.println(e.getMessage());
			}
			
			
		  
			WebElement connectionSuccessMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
			  if(connectionSuccessMsg.getText().equals("Test connection successful.")){
				  System.out.println("Test connection successful.");
			  }
			  else{
				  System.out.println("Test Connection NOT Successful");
			  }
			  WebElement okButton1 = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
			  okButton1.click();
		  
		  
//		  }
driver.quit();
}
}