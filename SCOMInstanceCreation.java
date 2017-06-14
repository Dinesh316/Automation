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

public class SCOMInstanceCreation {

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

		  WebElement navigationInstance = driver.findElement(By.xpath("//div[normalize-space()='Microsoft SCOM']"));
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

		  System.out.println("Creating Instance for hostname 'scom-win12-dev2'");
		  for(int j=0;j<6;j++){
				String[] inputHostName = {"scom-win12-dev2","scom-win12-dev2","sc16-dev3-sql","sc16-dev3-dw","sc16-dev4","sc16-dev4"};
				String[] inputPortName={"21433","21433","MSSQLSERVER","MSSQLSERVER","27345","27345"};
				String[] dbname={"OperationsManager","OperationsManagerDW","OperationsManager","OperationsManagerDW","OMDW2016","OM2016"};
				String[] creds={"MSSCOM Creds","MSSCOM Creds1","MSSCOM Creds1","MSSCOM Creds","MSSCOM Creds","MSSCOM Creds"};
				String[] sslValue={"No SSL","No SSL","No Verify","No Verify","No Verify","No Verify"};

				if(j!=0){
					  WebElement wait21 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@id,'addBtn')]")));
					  WebElement addButton = driver.findElement(By.xpath("//a[contains(@id,'addBtn')]"));
					  addButton.click();
				}
				if(j==2){
					System.out.println("Creating Instance for hostname 'sc16-dev3'");
				}
				if(j==4){
					System.out.println("Creating Instance for hostname 'sc16-dev4'");
				}
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  WebElement wait212 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[38]/td/table/tbody/tr/td/div")));
		  WebElement advancedSettings =driver.findElement(By.xpath("//tr[38]/td/table/tbody/tr/td/div"));
		  advancedSettings.click();
		  
		  WebElement instanceName = driver.findElement(By.xpath("//tr[descendant::td[contains(.,'Display Name')]]//input[@type='text']"));		
		  instanceName.clear();
		  instanceName.sendKeys("MSSCOM Instance "+j);
		  
		  WebElement hostName = driver.findElement(By.xpath("//tr[descendant::td[contains(.,'Database Host')]]//input[@type='text']"));
		  hostName.clear();
		  hostName.sendKeys(inputHostName[j]);	  
		  
		  WebElement portName = driver.findElement(By.xpath("//tr[descendant::td[contains(.,'Instance Name or Port')]]//input[@type='text']"));
		  portName.clear();
		  portName.sendKeys(inputPortName[j]);		  
		  
		  WebElement dbName = driver.findElement(By.xpath("//tr[descendant::td[contains(.,'Database Name')]]//input[@type='text']"));
		  dbName.clear();
		  dbName.sendKeys(dbname[j]);
		  
		  WebElement credsName = driver.findElement(By.xpath("//tr[descendant::td[contains(.,'Credential')]]//input[@type='text']"));
		  credsName.clear();
		  credsName.sendKeys(creds[j]);
		  
		  WebElement wait1 = (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//td//tr[descendant::td[contains(.,'SSL Config')]]//input[@type='text']")));
		  WebElement collectorNameClick=driver.findElement(By.xpath("//tr//td//tr[descendant::td[contains(.,'SSL Config')]]//input[@type='text']"));
		  collectorNameClick.clear();
		  collectorNameClick.sendKeys(sslValue[j]);
		//tr[descendant::td[div[normalize-space()='No SSL']]//input[@type='text']"	
		  WebElement testConnectionButton = driver.findElement(By.xpath("//span[normalize-space()='Test Connection']"));
		  WebElement wait11 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Test Connection']")));
		  testConnectionButton.click();
		  
		  WebElement wait12 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='messagebox-1002-msg']/div")));
		  
		  WebElement connectionSuccessMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
		  if(connectionSuccessMsg.getText().equals("Test connection successful.")){
		  	  System.out.println("PASSED: Test connection successful with hostName:" +inputHostName[j]+"portName:" +inputPortName[j]+"dbName:" +dbname[j]+"credentials:"+creds[j]);
		  }
		  else{
		  	  System.out.println("FAILED:Test connection NOT successful with hostName:" +inputHostName[j]+"portName:" +inputPortName[j]+"dbName:" +dbname[j]+"credentials:"+creds[j]);
		  }
//		  WebElement wait111 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='OK']")));
		  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton.click();
		  
		  WebElement wait22 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Save Settings']")));
		  
		  WebElement saveSettingsButton = driver.findElement(By.xpath("//span[normalize-space()='Save Settings']"));
		  saveSettingsButton.click();
		  
		  WebElement wait121 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='messagebox-1002-msg']/div")));
		  
		  WebElement infoMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
		  if(infoMsg.getText().equals("Adapter instance successfully saved.")){
			  System.out.println("Adapter instance successfully saved.");
		  }
		  else{
			  System.out.println("Problem in saving Adapter instance.");
		  }
		  WebElement wait1211 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='OK']")));
		  WebElement okButton2 = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton2.click();
		  
		 }

		  driver.quit();
}
}
