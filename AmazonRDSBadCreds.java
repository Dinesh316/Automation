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

public class AmazonRDSBadCreds {

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
				
		  WebElement addCredentialButton=driver.findElement(By.xpath("//tr[32]/td[3]/img"));
		  addCredentialButton.click();

			WebElement wait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.name("credentialName")));
			
		  WebElement credentialName=driver.findElement(By.name("credentialName"));
		  credentialName.clear();
		  credentialName.sendKeys("Bad Credentials02");
		  
		  WebElement secretAccessKey = driver.findElement(By.id("textfield-1360-inputEl"));
		  secretAccessKey.sendKeys("wrongacesskey");
		  
		  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton.click();
		  
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  WebElement testConnectionButton = driver.findElement(By.xpath("//a[normalize-space()='Test Connection']"));
		  testConnectionButton.click();
		  
		  try {
				Thread.sleep(5000);	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {

			FileUtils.copyFile(src, new File("/Users/dinesh/Desktop/images/image11"));
			}catch (IOException e) {
				 System.out.println(e.getMessage());
			}
		WebElement wait1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='messagebox-1002-msg']/div")));	
			
		  WebElement connectionSuccessMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
		  if(connectionSuccessMsg.getText().equals("Unable to establish a valid connection to the target system. The request signature we calculated does not match the signature you provided. Check your AWS Secret Access Key.")){
			  System.out.println("PASSED:Test Connection NOT Successful with secret access key: wrongacesskey");
		  }
		  else{
			  System.out.println("PASSED:Test Connection Successful with secret access key: wrongacesskey");
		  }
		  
		  WebElement okButton1 = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton1.click();

driver.quit();
}
}