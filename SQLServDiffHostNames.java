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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import org.apache.commons.io.FileUtils;

public class SQLServDiffHostNames {

	public static void main(String[] args) {

		  System.setProperty("webdriver.chrome.driver", "/Users/dinesh/Documents/BrowserDrivers/chromedriver");
		  WebDriver driver = new ChromeDriver();
		  
//		 ChromeOptions chromeOptions = new ChromeOptions();
//		  chromeOptions.addArguments("--kiosk");
//		  driver = new ChromeDriver(chromeOptions);
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

		  WebElement navigationInstance = driver.findElement(By.xpath("//div[normalize-space()='Microsoft SQL Server']"));
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
		  WebElement instanceName = driver.findElement(By.id("textfield-1344-inputEl"));
		  WebElement testConnectionButton = driver.findElement(By.xpath("//span[normalize-space()='Test Connection']"));

		  for(int j=0;j<3;j++){
				String[] inputHostName = {"mssql-ag1-sql","10.77.15.236","mssql-ag1-sql.bluemedora.localnet"};
		  
		  //Different host names	  
		  hostName.clear();
		  hostName.sendKeys(inputHostName[j]);	  
		  
		  instanceName.clear();
		  instanceName.sendKeys("MSSQLSERVER");		  
		  
		  testConnectionButton.click();
		  
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  WebElement connectionSuccessMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
		  if(connectionSuccessMsg.getText().equals("Test connection successful.")){
			  System.out.println("Test connection successful with hostname:"+inputHostName[j]);
		  }
		  else{
			  System.out.println("Test Connection NOT Successful with hostname:"+inputHostName[j]);
		  }
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {

			FileUtils.copyFile(src, new File("/Users/dinesh/Desktop/images/image"+j));
			}catch (IOException e) {
				 System.out.println(e.getMessage());
			}
		  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton.click();
		 }
		  driver.quit();
	}}