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
import org.w3c.dom.events.EventException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import org.apache.commons.io.FileUtils;

public class MSSCOMStartAndStopAdapter {


	public static void main(String[] args) throws EventException{

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
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		  
		  WebElement status = driver.findElement(By.xpath("//img[contains(@src,'images/clarity-light/resourcestates/resourceState_')]"));
		  status.click();
		  
		  WebElement stopButton = driver.findElement(By.xpath("//span[contains(@style,'background-image:url(images/clarity-light/i_Stopping.png);')]"));
		  stopButton.click();
		  
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			  
		  WebElement notCollecting = driver.findElement(By.xpath("//img[contains(@src,'images/clarity-light/resourcestates/resourceState_0.png')]"));
			 if(notCollecting.isDisplayed()){
				notCollecting.click();
			 }			 
				  
				  WebElement startButton = driver.findElement(By.xpath("//span[contains(@style,'background-image:url(images/clarity-light/i_Starting.png);')]"));
				  startButton.click();

				  try {
						Thread.sleep(5000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}  
				  WebElement started = driver.findElement(By.xpath("//img[contains(@src,'images/clarity-light/resourcestates/resourceState_1.png')]"));
					  if(started.isDisplayed()){
						  System.out.println("PASSED:Adapter Instance has started");
					  }
				else{
						  System.out.println("FAILED:Adapter Instance has not started");
					  }			
					
		  
					  
		  WebElement collecting = driver.findElement(By.xpath("//img[contains(@src,'images/clarity-light/resourcestates/resourceState_1.png')]"));
	
		  if(collecting.isDisplayed()){
			  collecting.click();
		  
			  stopButton.click();
			  
			  try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
			  WebElement stopped = driver.findElement(By.xpath("//img[contains(@src,'images/clarity-light/resourcestates/resourceState_0.png')]"));
				  if(stopped.isDisplayed()){
					  System.out.println("PASSED:Adapter Instance has stopped");
					  WebElement status1 = driver.findElement(By.xpath("//img[contains(@src,'images/clarity-light/resourcestates/resourceState_')]"));
					  status1.click();
					  startButton.click();
				  }
				  else{
					  System.out.println("FAILED:Adapter Instance has not stopped");
				  }
  } 
		  driver.quit();
				
		  }


	}


