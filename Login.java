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

public class Login {

	public void LoginApplication() throws Exception {
	System.setProperty("webdriver.chrome.driver", "/Users/dinesh/Documents/BrowserDrivers/chromedriver");
	  WebDriver driver = new ChromeDriver();
	  
	//  ChromeOptions chromeOptions = new ChromeOptions()
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
}
}