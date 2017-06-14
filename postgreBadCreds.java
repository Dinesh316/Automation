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

public class postgreBadCreds {

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

		  WebElement navigationInstance = driver.findElement(By.xpath("//div[normalize-space()='PostgreSQL Adapter']"));
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
		  
		  WebElement hostName = driver.findElement(By.name("textfield-1343-inputEl"));
		  hostName.clear();
		  hostName.sendKeys("pg94-rh7");
		  
		  WebElement portName = driver.findElement(By.id("textfield-1344-inputEl"));
		  portName.clear();
		  portName.sendKeys("5432");
		  
		  WebElement dbName = driver.findElement(By.id("textfield-1345-inputEl"));
		  dbName.clear();
		  dbName.sendKeys("postgres");

		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		  for(int j=0;j<1;j++){
				String[] username = {"testtest"};
				String[] password1 = {"wrong"};
				
		  WebElement addCredentialButton=driver.findElement(By.xpath("//tr[32]/td[3]/img"));
		  addCredentialButton.click();

			WebElement wait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.name("credentialName")));
			
		  WebElement credentialName=driver.findElement(By.name("credentialName"));
		  credentialName.clear();
		  credentialName.sendKeys("Bad Credentials"+j+j);
		  
		  WebElement userName1 = driver.findElement(By.id("textfield-1366-inputEl"));
		  userName1.clear();
		  userName1.sendKeys(username[j]);
		  
		  WebElement password11 = driver.findElement(By.id("textfield-1367-inputEl"));
		  password11.clear();
		  password11.sendKeys(password1[j]);
		  
		  WebElement vrealizeUname = driver.findElement(By.id("textfield-1368-inputEl"));
		  vrealizeUname.clear();
		  vrealizeUname.sendKeys("admin");
		  
		  WebElement vrealizePassword = driver.findElement(By.id("textfield-1369-inputEl"));
		  vrealizePassword.clear();
		  vrealizePassword.sendKeys("P@ssw0rd1");
		  
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

			FileUtils.copyFile(src, new File("/Users/dinesh/Desktop/images/image"+j));
			}catch (IOException e) {
				 System.out.println(e.getMessage());
			}
		  
		  WebElement msgType = driver.findElement(By.xpath("//div[normalize-space()='Error']"));
		  if(msgType.getText().equals("Error")){
			  System.out.println("PASSED:Test Connection NOT Successful with username:"+ username[j]+" password:"+password1[j]);
		  }
		  else{
			  System.out.println("FAILED:Test Connection Successfulwith username:"+ username[j]+" password:"+password1[j]);
		  }
		  
		  WebElement okButton1 = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton1.click();
		  
		  
		  }
driver.quit();
}
}