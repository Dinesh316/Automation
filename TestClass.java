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
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import org.apache.commons.io.FileUtils;


public class TestClass {

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
//  String[] links={"Dashboards","Alerts","Environment","Administration","Home"};
//  int x;
//  for(x=0;x<5;x++){
//  WebElement navigationLinks = driver.findElement(By.linkText(links[x]));
//  navigationLinks.click();
//  System.out.println(links[x] + "Link is Clicked");
 
  WebElement navigationLinks = driver.findElement(By.linkText("Dashboards"));
  navigationLinks.click();

  try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	e.printStackTrace();
}  
  
//   	  navigationLinks = driver.findElement(By.xpath("//a[normalize-space()='All Dashboards']"));
//
//	  navigationLinks.click();
//	  navigationLinks.sendKeys("Enter");
	  
//   	  navigationLinks = driver.findElement(By.xpath("//a[normalize-space()='MySQL']"));
//
//	  navigationLinks.click();
//	  navigationLinks.sendKeys("Enter");
	  
//	  if ( !driver.findElement(By.xpath("//a[normalize-space()='MySQL']")).isSelected() )
//	  {
//	       driver.findElement(By.xpath("//a[normalize-space()='MySQL']")).click();
////	       System.out.println("got here");
//	  }
	  
	  WebElement navigationLinks1 = driver.findElement(By.xpath("//li[normalize-space()='E-Series Volume Overview']"));

	  navigationLinks1.click();
//	  navigationLinks.sendKeys("Enter");
	  
	  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
//	  
//	  WebElement navigationLinks2 = driver.findElement(By.xpath("//div[normalize-space()='DP1_Thick_Vol_1']"));
//	 //mysql57-rh7/tpcc
//	  navigationLinks2.click();
////	  navigationLinks2.sendKeys("Enter");
	  
	  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
	  String XPath="//div[normalize-space()='DP1_Thin_X']";
	  WebElement navigationLinks21 = driver.findElement(By.xpath(XPath));
	  navigationLinks21.click();
	  
	  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
//	  driver.findElement(By.xpath("//tspan[text()='repos_0003']")).click();
	  String XPath1="//a[normalize-space()='DP1_Thin_X']";
//	  
//	  String kk ="//*[@id='customSelect_3']/.//span[contains(@class,'selectLabel')]";

	  int iCount = 0;
	  iCount = driver.findElements(By.xpath(XPath1)).size();  
	  System.out.println(iCount);
	 if (iCount > 1) {
	  System.out.println(iCount + " elements were displayed with the given name");
	 }

///
//  new Select (driver.findElement(By.id("button-1163"))).selectByValue("MySQL");

//  navigationLinks = driver.findElement(By.linkText("Home"));ß
//  navigationLinks.click();
//  navigationLinks = driver.findElement(By.linkText("Home"));
//  navigationLinks.click();
  
//		  objectNavigatorToolbarHomeDashboardBtn-btnInnerEl
//		  navigationLinks = driver.	
//		  findElement(By.id("loginBtn-btnInnerEl"));
//  loginButton.click();
//  
//  class="nav-text x-btn-text"
//		  id="objectNavigatorToolbarHomeDashboardBtn-btnInnerEl"
//		  name="Home"
//  driver.quit();

	 WebElement navigationLinks3 = driver.findElement(By.xpath("//li[normalize-space()='E-Series Health Investigation']"));

	  navigationLinks3.click();
	  
	  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
	  
//	  "32x32","42x42",
for(int j=0;j<3;j++){
	String[] imgSize = {"24x24"};

	  List<WebElement> imgLinks = driver.findElements(By.xpath("//img[contains(@src,'images/badge/square_"+imgSize[j]+"_health_0')]"));
	  iCount=imgLinks.size();
	  System.out.println(iCount);
	  for(int i=0;i<iCount;i++) {
		 if(imgLinks.get(i).isDisplayed()) {
			 imgLinks.get(i).click();
		 }
		 else{
		 System.out.println("Unable to Click image link"+imgLinks.get(i));
		 }
		 
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {

	FileUtils.copyFile(src, new File("/Users/dinesh/Desktop/images/image"+i));
	}

	catch (IOException e) {
	 System.out.println(e.getMessage());
	}
	}
	  
	  

	  }
driver.quit();
	  
}

}
	
		
		


