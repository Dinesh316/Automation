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

public class ExcelBadAdapterProperties {

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
		  String searchkey="Microsoft SCOM";

		  WebElement navigationInstance = driver.findElement(By.xpath("//div[normalize-space()='"+searchkey+"']"));
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
		  		String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";

		        File file =    new File("/Users/dinesh/Desktop/BadAdapterProperties.xls");
		        

		        Workbook names = null;
		        FileInputStream inputStream = new FileInputStream(file);
		        names = new HSSFWorkbook(inputStream);
		        Sheet sheet = names.getSheet("namesSheet");
		        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
//		        System.out.println(sheet.getLastRowNum());
//		      System.out.println(sheet.getLastRowNum());
//		      System.out.println(sheet.getFirstRowNum());
		        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
 		        	if(i==1){
						  WebElement wait21 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@id,'addBtn')]")));
						  WebElement addButton = driver.findElement(By.xpath("//a[contains(@id,'addBtn')]"));
						  addButton.click();
						  
			           		 try {
					 				Thread.sleep(5000);
					 			} catch (InterruptedException e) {
					 				// TODO Auto-generated catch block
					 				e.printStackTrace();
					 			}
			           		 
		        	WebElement wait212 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//td//tr[ancestor::td[contains(.,'Advanced Settings')]]//div[@expanded='0']")));
   				  	WebElement advancedSettings =driver.findElement(By.xpath("//tr//td//tr[ancestor::td[contains(.,'Advanced Settings')]]//div[@expanded='0']"));
   				  	advancedSettings.click();
					}
				  	
		            Row row = sheet.getRow(i);
		            	DataFormatter formatter = new DataFormatter();
		            	Cell cell = sheet.getRow(i).getCell(0);
		            	 String keyValue = formatter.formatCellValue(cell);

		            	 if(keyValue.equals(searchkey)){
				        	 
		            		 try {
				 				Thread.sleep(5000);
				 			} catch (InterruptedException e) {
				 				// TODO Auto-generated catch block
				 				e.printStackTrace();
				 			}
		   				  
		            		 int rowvalue=i;
		            		 for(int columnvalue=1;columnvalue<row.getLastCellNum();columnvalue++){
		            			 Cell columnValue=sheet.getRow(0).getCell(columnvalue);
		            			 Cell value = sheet.getRow(rowvalue).getCell(columnvalue);
		            			 String heading = formatter.formatCellValue(columnValue);
		            			 String actValue=formatter.formatCellValue(value);
		            			 
		            			 if(heading.equals("Collectors/Groups")||heading.equals("SSL Config")||heading.equals("Auto Discovery")||heading.equals("Max Events")||heading.equals("Support Autodiscovery")){
		            				 if(!"".equals(actValue)){
		            				 WebElement wait1 = (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//td//tr[descendant::td[contains(.,'"+heading+"')]]//input[@type='text']")));
		            				  WebElement collectorNameClick=driver.findElement(By.xpath("//tr//td//tr[descendant::td[contains(.,'"+heading+"')]]//input[@type='text']"));
		            				  collectorNameClick.clear();
		            				  collectorNameClick.sendKeys(actValue);
		            			 }}
		            			 
		            			 else if(heading.equals("Description")){
		            				 if(!"".equals(actValue)){
		            				 WebElement wait1 = (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[descendant::td[contains(.,'Description')]]//textarea[@role='textbox']")));
		            				  WebElement collectorNameClick=driver.findElement(By.xpath("//tr[descendant::td[contains(.,'Description')]]//textarea[@role='textbox']"));
		            				  collectorNameClick.clear();
		            				  collectorNameClick.sendKeys(actValue);
		            			 }}
		            			 else if(!"".equals(actValue)){
		            				 WebElement instanceName = driver.findElement(By.xpath("//tr[descendant::td[contains(.,'"+heading+"')]]//input[@type='text']"));		
		            				  instanceName.clear();
		            				  instanceName.sendKeys(actValue);
		            			 }
		            			//tr[descendant::td[contains(.,"Description")]]//textarea[@role='textbox']
		            		      
		            		 }	
									  WebElement testConnectionButton = driver.findElement(By.xpath("//span[normalize-space()='Test Connection']"));
									  WebElement wait11 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Test Connection']")));
									  testConnectionButton.click();
									  
									  WebElement wait12 = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[descendant::div[contains(.,'Error')]]//div[contains(@data-ref,'textEl')]")));
									  
									  WebElement connectionSuccessMsg = driver.findElement(By.xpath("//div[descendant::div[contains(.,'Error')]]//div[contains(@data-ref,'textEl')]"));
									  if(connectionSuccessMsg.getText().equals("Error")){
									  	  System.out.println("PASSED: Test connection unsuccessful. The Error message is as below:");
									  }
									  else{
									  	  System.out.println("FAILED:Test connection successful. The Error message is as below: ");
									  }
									  WebElement infoMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
									  System.out.println(infoMsg.getText());
										  
									  
							//		  WebElement wait111 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='OK']")));
									  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
									  okButton.click();
								
				            		 
					            	 }
						        }
		  driver.quit();

}

}

