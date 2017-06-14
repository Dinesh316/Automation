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

public class ExcelInstanceCreation {

	public static void main(String[] args) throws IOException {
		
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
		 
		  WebElement navigationLinks = driver.findElement(By.linkText("Administration"));
		  navigationLinks.click();

		  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
       	
       	String searchkey="Credentials Microsoft SCOM";
       	String searchkey1="Microsoft SCOM";
      //tr//td//img[contains(@id,'btnAddCredential')]
      		  WebElement navigationInstance = driver.findElement(By.xpath("//div[normalize-space()='"+searchkey1+"']"));
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

      		        File file =    new File("/Users/dinesh/Desktop/InstanceCreation.xls");
      		        

      		        Workbook names = null;
      		        FileInputStream inputStream = new FileInputStream(file);
      		        names = new HSSFWorkbook(inputStream);
      		        Sheet sheet = names.getSheet("namesSheet");
      		        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
//      		        System.out.println(sheet.getLastRowNum());
//      		      System.out.println(sheet.getLastRowNum());
//      		      System.out.println(sheet.getFirstRowNum());
      		        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
      				  
      		            Row row = sheet.getRow(i);
      		            	DataFormatter formatter = new DataFormatter();
      		            	Cell cell = sheet.getRow(i).getCell(0);
      		            	 String keyValue = formatter.formatCellValue(cell);
      		            	 
      		            	 try {
      		      				Thread.sleep(3000);
      		      			} catch (InterruptedException e) {
      		      				// TODO Auto-generated catch block
      		      				e.printStackTrace();
      		      			}

      		            	 if(keyValue.equals(searchkey)){

      		 		      		  WebElement wait22 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//td//img[contains(@id,'btnAddCredential')]")));
      		 					  WebElement addButton = driver.findElement(By.xpath("//tr//td//img[contains(@id,'btnAddCredential')]"));
      		 					  addButton.click();
      		 					  
      		 					 try {
       				 				Thread.sleep(3000);
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
     		            			 
     		            			if(heading.equals("credentialName")||heading.equals("user")){
     		            				 if(!"".equals(actValue)){
     		            				 WebElement wait1 = (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//input[contains(@name,'"+heading+"')]")));
     		            				  WebElement credentials=driver.findElement(By.xpath("//div//div//input[contains(@name,'"+heading+"')]"));
     		            				 credentials.clear();
     		            				credentials.sendKeys(actValue);
     		            			
     		            			}}
     		            			if(heading.equals("password")){
     		            				if(!"".equals(actValue)){
        		            				 WebElement wait1 = (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//input[contains(@type,'"+heading+"')]")));
        		            				  WebElement credentials=driver.findElement(By.xpath("//div//div//input[contains(@type,'"+heading+"')]"));
        		            				 credentials.clear();
        		            				credentials.sendKeys(actValue);
     		            				
     		            			
     		            			WebElement wait111 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='OK']")));
    									  WebElement okButton = driver.findElement(By.xpath("//a[normalize-space()='OK']"));
    									  okButton.click();
    									 
    									  
     		            				}}

     		            			

      		            	 }
      		   				  
      		            	 }	
      		        }		 

		  
		  try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	  
		  		String filePath1 = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
		        File file1 =    new File("/Users/dinesh/Desktop/InstanceCreation.xls");
		        Workbook names1 = null;

		        FileInputStream inputStream1 = new FileInputStream(file1);
		        names1 = new HSSFWorkbook(inputStream1);
		        Sheet sheet1 = names1.getSheet("namesSheet");
		        int rowCount1 = sheet1.getLastRowNum()-sheet1.getFirstRowNum();
//		        System.out.println(sheet.getLastRowNum());
//		      System.out.println(sheet.getLastRowNum());
//		      System.out.println(sheet.getFirstRowNum());
		        for (int i1 = 1; i1 <= sheet1.getLastRowNum(); i1++) {
				  
		            Row row = sheet1.getRow(i1);
		            	DataFormatter formatter1 = new DataFormatter();
		            	Cell cell1 = sheet1.getRow(i1).getCell(0);
		            	 String keyValue1 = formatter1.formatCellValue(cell1);

		            	 if(keyValue1.equals(searchkey1)){
		 		        	if(i1!=1){
								  WebElement wait21 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@id,'addBtn')]")));
								  WebElement addButton = driver.findElement(By.xpath("//a[contains(@id,'addBtn')]"));
								  addButton.click();
							}

				        	 try {
				 				Thread.sleep(3000);
				 			} catch (InterruptedException e) {
				 				// TODO Auto-generated catch block
				 				e.printStackTrace();
				 			}
		            		 
		            		 WebElement wait212 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//td//tr[ancestor::td[contains(.,'Advanced Settings')]]//div[@expanded='0']")));
		   				  	WebElement advancedSettings =driver.findElement(By.xpath("//tr//td//tr[ancestor::td[contains(.,'Advanced Settings')]]//div[@expanded='0']"));
		   				  	advancedSettings.click();
		   				  
		            		 int rowvalue=i1;
		            		 for(int columnvalue=1;columnvalue<row.getLastCellNum();columnvalue++){
		            			 Cell columnValue=sheet1.getRow(0).getCell(columnvalue);
		            			 Cell value = sheet1.getRow(rowvalue).getCell(columnvalue);
		            			 String heading = formatter1.formatCellValue(columnValue);
		            			 String actValue=formatter1.formatCellValue(value);
		            			
		            			 
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
		            		      
		            		 }
									  WebElement testConnectionButton = driver.findElement(By.xpath("//span[normalize-space()='Test Connection']"));
									  WebElement wait11 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Test Connection']")));
									  testConnectionButton.click();
									  
									  WebElement wait12 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='messagebox-1002-msg']/div")));
									  
									  WebElement connectionSuccessMsg = driver.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
									  if(connectionSuccessMsg.getText().equals("Test connection successful.")){
									  	  System.out.println("PASSED: Test connection successful");
									  }
									  else{
									  	  System.out.println("FAILED:Test connection NOT successful ");
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
//		            					}
		            			
				            		 
					            	 }
						        }
		  driver.quit();

}

}

