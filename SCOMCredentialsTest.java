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

public class SCOMCredentialsTest {

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


		  WebElement wait212 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[38]/td/table/tbody/tr/td/div")));
		  WebElement advancedSettings =driver.findElement(By.xpath("//tr[38]/td/table/tbody/tr/td/div"));
		  advancedSettings.click();
		  
		  WebElement collectorNameArrow=driver.findElement(By.xpath("//tr[2]/td[2]/div/div/div/div[2]"));
		  WebElement testConnectionButton = driver.findElement(By.xpath("//span[normalize-space()='Test Connection']"));
		  
		  System.out.println("Testing for hostname 'scom-win12-dev2'");
		  for(int j=0;j<6;j++){
				String inputHostName = "scom-win12-dev2";
				String inputPortName="21433";
				String[] dbname={"OperationsManager","OperationsManager","OperationsManager","OperationsManagerDW","OperationsManagerDW","OperationsManagerDW"};
				String[] creds={"MSSCOM Creds","MSSCOM Creds1","MSSCOM Creds2","MSSCOM Creds","MSSCOM Creds1","MSSCOM Creds2"};

		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  WebElement hostName = driver.findElement(By.name("textfield-1343-inputEl"));
		  hostName.clear();
		  hostName.sendKeys(inputHostName);	  
		  
		  WebElement portName = driver.findElement(By.id("textfield-1344-inputEl"));
		  portName.clear();
		  portName.sendKeys(inputPortName);		  
		  
		  WebElement dbName = driver.findElement(By.id("textfield-1345-inputEl"));
		  dbName.clear();
		  dbName.sendKeys(dbname[j]);
		  
		  WebElement credsName = driver.findElement(By.id("clearablecombo-1336-inputEl"));
		  credsName.clear();
		  credsName.sendKeys(creds[j]);

		  WebElement wait2 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[2]/td[2]/div/div/div/div[2]")));
		  collectorNameArrow.click();
		  
		  WebElement wait1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='No SSL']")));
		  WebElement collectorNameClick=driver.findElement(By.xpath("//div[normalize-space()='No SSL']"));
		  collectorNameClick.click();
		  
		  WebElement wait11 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Test Connection']")));
		  testConnectionButton.click();
		  
		  WebElement wait12 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='messagebox-1002-msg']/div")));
		  
		  WebElement connectionSuccessMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
		  if(connectionSuccessMsg.getText().equals("Test connection successful.")){
		  	  System.out.println("PASSED: Test connection successful with hostName:" +inputHostName+"portName:" +inputPortName+"dbName:" +dbname[j]+"credentials:"+creds[j]);
		  }
		  else{
		  	  System.out.println("FAILED:Test connection NOT successful with hostName:" +inputHostName+"portName:" +inputPortName+"dbName:" +dbname[j]+"credentials:"+creds[j]);
		  }
		  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton.click();
		  
		 }
		  
		  System.out.println("Testing for hostname 'sc16-dev3-sql'");
		  for(int j=0;j<6;j++){
				String[] inputHostName = {"sc16-dev3-sql","sc16-dev3-sql","sc16-dev3-sql","sc16-dev3-dw","sc16-dev3-dw","sc16-dev3-dw"};
				String inputPortName="MSSQLSERVER";
				String[] dbname={"OperationsManager","OperationsManager","OperationsManager","OperationsManagerDW","OperationsManagerDW","OperationsManagerDW"};
				String[] creds={"MSSCOM Creds","MSSCOM Creds1","MSSCOM Creds2","MSSCOM Creds","MSSCOM Creds","MSSCOM Creds"};
		  
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  WebElement hostName = driver.findElement(By.name("textfield-1343-inputEl"));
		  hostName.clear();
		  hostName.sendKeys(inputHostName[j]);	  
		  
		  WebElement portName = driver.findElement(By.id("textfield-1344-inputEl"));
		  portName.clear();
		  portName.sendKeys(inputPortName);		  
		  
		  WebElement dbName = driver.findElement(By.id("textfield-1345-inputEl"));
		  dbName.clear();
		  dbName.sendKeys(dbname[j]);
		  
		  WebElement credsName = driver.findElement(By.id("clearablecombo-1336-inputEl"));
		  credsName.clear();
		  credsName.sendKeys(creds[j]);
		  
		  WebElement wait2 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[2]/td[2]/div/div/div/div[2]")));
		  collectorNameArrow.click();
		  
		  WebElement wait1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='No Verify']")));
		  WebElement collectorNameClick=driver.findElement(By.xpath("//div[normalize-space()='No Verify']"));
		  collectorNameClick.click();
		  
		  WebElement wait11 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Test Connection']")));
		  testConnectionButton.click();
		  
		  WebElement wait12 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='messagebox-1002-msg']/div")));

		  WebElement connectionSuccessMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
		  if(connectionSuccessMsg.getText().equals("Test connection successful.")){
		  	  System.out.println("PASSED: Test connection successful with hostName:" +inputHostName[j]+"portName:" +inputPortName+"dbName:" +dbname[j]+"credentials:"+creds[j]);
		  }
		  else{
		  	  System.out.println("FAILED:Test connection NOT successful with hostName:" +inputHostName[j]+"portName:" +inputPortName+"dbName:" +dbname[j]+"credentials:"+creds[j]);
		  }
		  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton.click();
		 }
		  
		  System.out.println("Testing for hostname 'sc16-dev4'");
		  for(int j=0;j<6;j++){
				String inputHostName = "sc16-dev4";
				String inputPortName="27345";
				String[] dbname={"OMDW2016","OMDW2016","OMDW2016","OM2016","OM2016","OM2016","OM2016"};
				String[] creds={"MSSCOM Creds","MSSCOM Creds","MSSCOM Creds","MSSCOM Creds","MSSCOM Creds1","MSSCOM Creds2","MSSCOM Creds"};
		  
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  WebElement hostName = driver.findElement(By.name("textfield-1343-inputEl"));
		  hostName.clear();
		  hostName.sendKeys(inputHostName);	  
		  
		  WebElement portName = driver.findElement(By.id("textfield-1344-inputEl"));
		  portName.clear();
		  portName.sendKeys(inputPortName);		  
		  
		  WebElement dbName = driver.findElement(By.id("textfield-1345-inputEl"));
		  dbName.clear();
		  dbName.sendKeys(dbname[j]);
		  
		  WebElement credsName = driver.findElement(By.id("clearablecombo-1336-inputEl"));
		  credsName.clear();
		  credsName.sendKeys(creds[j]);
		  
		  WebElement wait2 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[2]/td[2]/div/div/div/div[2]")));
		  collectorNameArrow.click();
		  
		  WebElement wait1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='No Verify']")));
		  WebElement collectorNameClick=driver.findElement(By.xpath("//div[normalize-space()='No Verify']"));
		  collectorNameClick.click();
		  
		  WebElement wait11 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Test Connection']")));
		  testConnectionButton.click();
		  
		  WebElement wait12 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='messagebox-1002-msg']/div")));

		  WebElement connectionSuccessMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
		  if(connectionSuccessMsg.getText().equals("Test connection successful.")){
		  	  System.out.println("PASSED: Test connection successful with hostName:" +inputHostName+"portName:" +inputPortName+"dbName:" +dbname[j]+"credentials:"+creds[j]);
		  }
		  else{
		  	  System.out.println("FAILED:Test connection NOT successful with hostName:" +inputHostName+"portName:" +inputPortName+"dbName:" +dbname[j]+"credentials:"+creds[j]);
		  }

		  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton.click();
		 }

		  System.out.println("Testing for Bad Credentials");
		  for(int j=0;j<9;j++){
				String[] inputHostName ={"WrongHostname","123456","!@#$%^","scom-win12-dev2","scom-win12-dev2","scom-win12-dev2","scom-win12-dev2","scom-win12-dev2","scom-win12-dev2"};
				String[] inputPortName={"21433","21433","21433","WrongPortname","213546879654","!@#$%^","21433","21433","21433"};
				String[] dbname={"OperationsManager","OperationsManager","OperationsManager","OperationsManager","OperationsManager","OperationsManager","WrongDB","!@#$%^","34569846165"};
				String creds= "MSSCOM Creds";
				
				WebElement hostName = driver.findElement(By.name("textfield-1343-inputEl"));
				  hostName.clear();
				  hostName.sendKeys(inputHostName[j]);	  
				  
				  WebElement portName = driver.findElement(By.id("textfield-1344-inputEl"));
				  portName.clear();
				  portName.sendKeys(inputPortName[j]);		  
				  
				  WebElement dbName = driver.findElement(By.id("textfield-1345-inputEl"));
				  dbName.clear();
				  dbName.sendKeys(dbname[j]);
				  
				  WebElement credsName = driver.findElement(By.id("clearablecombo-1336-inputEl"));
				  credsName.clear();
				  credsName.sendKeys(creds);
		  
		  WebElement wait2 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[2]/td[2]/div/div/div/div[2]")));
		  collectorNameArrow.click();
		  
		  WebElement wait1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='No SSL']")));
		  WebElement collectorNameClick=driver.findElement(By.xpath("//div[normalize-space()='No SSL']"));
		  collectorNameClick.click();
		  
		  WebElement wait11 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Test Connection']")));
		  testConnectionButton.click();
		  
		  WebElement wait12 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='messagebox-1002-msg']/div")));

		  WebElement msgType = driver.findElement(By.id("title-1352-textEl"));
		  if(msgType.getText().equals("Error")){
		  	  System.out.println("PASSED: Test connection NOT successful with hostName:" +inputHostName[j]+"portName:" +inputPortName[j]+"dbName:" +dbname[j]+"credentials:"+creds);
		  }
		  else{
		  	  System.out.println("FAILED:Test connection successful with hostName:" +inputHostName[j]+"portName:" +inputPortName[j]+"dbName:" +dbname[j]+"credentials:"+creds);
		  }

		  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton.click();
		 }
		  driver.quit();
}
}
