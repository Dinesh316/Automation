package TestPackage;

import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class FileUpload {

	public static void main(String[] args) throws IOException {
		
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
       	
		  WebElement wait22 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span//span//span[contains(@style,'background-image:url(themes/clarity-light/images/app/toolbar/add.png);')]")));
		  WebElement addButton = driver.findElement(By.xpath("//a//span//span//span[contains(@style,'background-image:url(themes/clarity-light/images/app/toolbar/add.png);')]"));
		  addButton.click();
		  
		  driver.findElement(By.xpath("//input[@data-ref='fileInputEl' and @accept='.pak']")).sendKeys("/Users/dinesh/Documents/Management packs/MicrosoftSCOM-6.3.10100008.pak");
		  
		  try {			  
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		  
		  WebElement wait3 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//label[contains(.,'Install the PAK file even if it is already installed.')]")));
		  WebElement installPAKCheckbox = driver.findElement(By.xpath("//div//div//label[contains(.,'Install the PAK file even if it is already installed.')]"));
		  installPAKCheckbox.click();
		  
		  WebElement wait4 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//label[contains(.,'Reset Default Content,')]")));
		  WebElement resetDefaultCheckBox = driver.findElement(By.xpath("//div//div//label[contains(.,'Reset Default Content,')]"));
		  resetDefaultCheckBox.click();
		  
		  WebElement wait5 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//label[contains(.,'I understand')]")));
		  WebElement IunderstandCheckButton = driver.findElement(By.xpath("//div//div//label[contains(.,'I understand')]"));
		  IunderstandCheckButton.click();
		  
		  WebElement wait1211 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='OK']")));
		  WebElement okButton2 = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
		  okButton2.click();
		  
		
		  WebElement wait2 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//div//span//span//span[contains(.,'Upload')]")));
		  WebElement uploadButton = driver.findElement(By.xpath("//div//div//div//span//span//span[contains(.,'Upload')]"));
		  uploadButton.click();

		  WebElement myDynamicElement = (new WebDriverWait(driver, 600)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr//td[contains(.,'The PAK file has been uploaded and is ready to install.')]")));
		  
		  WebElement wait21 = (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//div//span//span//span[contains(.,'Next')]")));

		  WebElement NextButton = driver.findElement(By.xpath("//div//div//div//span//span//span[contains(.,'Next')]"));
		  NextButton.click();

		  WebElement wait212 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Yes']")));
		  WebElement YesButton = driver.findElement(By.xpath("//a[normalize-space()='Yes']"));
		  YesButton.click();
		  
		  try {			  
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		  
		  WebElement wait = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//label[contains(.,'I accept the terms of this agreement')]")));
		  WebElement agreementButton = driver.findElement(By.xpath("//div//label[contains(.,'I accept the terms of this agreement')]"));
		  agreementButton.click();
		  
		  try {			  
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		  
		  WebElement wait2122 = (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//div//span//span//span[contains(.,'Next')]")));
		  WebElement NextButton1 = driver.findElement(By.xpath("//div//div//div//span//span//span[contains(.,'Next')]"));
		  NextButton1.click();
		  
		  
		  WebElement finishButton = (new WebDriverWait(driver, 1200)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//div//span//span//span[contains(.,'Finish')]")));
		  finishButton.click();
		  
		  	try {			  
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		
		  
		  WebElement wait2222 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//label[contains(.,'Management')]")));
		  	WebElement managementLink =driver.findElement(By.xpath("//div//div//label[contains(.,'Management')]"));
		  	managementLink.click();
		  
		    WebElement wait222 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//section//span[contains(.,'Licensing')]")));
		  	WebElement licensingLink =driver.findElement(By.xpath("//div//section//span[contains(.,'Licensing')]"));
		  	licensingLink.click();
		  	
		  	try {			  
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		  	
		  	
			  WebElement wait221 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span//span//span[contains(@style,'background-image:url(themes/clarity-light/images/app/toolbar/add.png);')]")));
			  WebElement addButton1 = driver.findElement(By.xpath("//a//span//span//span[contains(@style,'background-image:url(themes/clarity-light/images/app/toolbar/add.png);')]"));
			  addButton1.click();
			  
			  WebElement wait2212 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='product-combo-inputEl'and @role='combobox']")));
			  WebElement solution= driver.findElement(By.xpath("//input[@name='product-combo-inputEl'and @role='combobox']"));
			  solution.click();
			  driver.findElement(By.xpath("//div//ul//div[contains(.,'Microsoft SCOM')]")).click();;

			  
			  WebElement licenseKey = driver.findElement(By.xpath("//input[@name='licenseKeyValue'and @role='textbox']"));
			  licenseKey.sendKeys("4/trialparticipant/06-08-2017-16:05:43/BM-VREALIZE-MSSCOM/trial/03-04-2020-16:05:43/MP/accumulating/BM-VREALIZE-MSSCOM/Unlimited/5BC79887AC6AC3A30D741C4F7D34A153EA2B5CFF");
			
			  WebElement wait6 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span//span//span[contains(.,'Validate')]")));
			  WebElement validateButton = driver.findElement(By.xpath("//a//span//span//span[contains(.,'Validate')]"));
			  validateButton.click();
			  
			  WebElement myDynamicElement1 = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//div//p[contains(.,'License key validated successfully.')]")));
			
			  if(myDynamicElement1.isDisplayed()){
				  System.out.println("License key validated successfully");
				  
				  WebElement wait7 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span//span//span[contains(.,'Save')]")));
				  WebElement saveButton = driver.findElement(By.xpath("//a//span//span//span[contains(.,'Save')]"));
				  saveButton.click();
				
			  }
			  else{
				  System.out.println("License key not validated successfully");
			  }
	     
		//  driver.quit();

}

}

