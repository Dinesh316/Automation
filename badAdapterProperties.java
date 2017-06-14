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

public class badAdapterProperties {

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

		  WebElement navigationInstance = driver.findElement(By.xpath("//div[normalize-space()='MySQL Adapter']"));
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
		  WebElement portName = driver.findElement(By.id("textfield-1344-inputEl"));
		  WebElement dbName = driver.findElement(By.id("textfield-1345-inputEl"));
		  WebElement testConnectionButton = driver.findElement(By.xpath("//span[normalize-space()='Test Connection']"));

		  for(int j=0;j<3;j++){
				String[] inputHostName = {"WrongHostname","123456","!@#$%^"};
		  
		  //Bad hostname	  
		  hostName.clear();
		  hostName.sendKeys(inputHostName[j]);	  
		  
		  portName.clear();
		  portName.sendKeys("3306");		  
		  
		  dbName.clear();
		  dbName.sendKeys("tpcc");
		  
		  testConnectionButton.click();
		  
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  WebElement msgType = driver.findElement(By.id("title-1354-textEl"));
		  if(msgType.getText().equals("Error"))
		  {
			  System.out.println("PASSED:Expected Host error message Appeared.Displayed message is as below:");
		  }
		  else{
			  System.out.println("FAILED:Expected Host error message didnot appear.Displayed message is as below:");
		  }
		  
		  WebElement infoMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
		  System.out.println(infoMsg.getText());
		
		  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton.click();
		 }
		  
		  for(int j=0;j<2;j++){
				String[] inputPortName = {"213546879654","!@#$%^"};
		  
		  hostName.clear();
		  hostName.sendKeys("mysql57-rh7");
		  
//		 Bad Port Name
		  portName.clear();
		  portName.sendKeys(inputPortName[j]);
		  
		  dbName.clear();
		  dbName.sendKeys("tpcc");

		  testConnectionButton.click();
		  
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  WebElement msgType = driver.findElement(By.id("title-1354-textEl"));
		  if(msgType.getText().equals("Error"))
		  {
			  System.out.println("PASSED:Expected Port error message Appeared.Displayed message is as below:");
		  }
		  else{
			  System.out.println("FAILED:Expected Port error message didnot appear.Displayed message is as below:");
		  }
		  
		  WebElement infoMsg1 = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
		  System.out.println(infoMsg1.getText());
		  
		  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton.click();
		  }
		  
		  
		  for(int j=0;j<2;j++){
				String[] inputDBName = {"WrongDB","!@#$%^","34569846165"}; 
		  hostName.clear();
		  hostName.sendKeys("mysql57-rh7");
		  

		  portName.clear();
		  portName.sendKeys("3306");
		
//		Bad DB Name
		  dbName.clear();
		  dbName.sendKeys(inputDBName[j]);

		  testConnectionButton.click();
		  
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  WebElement msgType = driver.findElement(By.id("title-1354-textEl"));
		  if(msgType.getText().equals("Error"))
		  {
			  System.out.println("PASSED:Expected DB Name error message Appeared.Displayed message is as below:");
		  }
		  else{
			  System.out.println("FAILED:Expected DB Name error message didnot appear.Displayed message is as below:");
		  }
		  
		  WebElement infoMsg11 = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
		  System.out.println(infoMsg11.getText());
		  
		  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton.click();
		  }
		  driver.quit();
}
}