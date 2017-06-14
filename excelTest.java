package TestPackage;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class excelTest {

public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

    File file =    new File("/Users/dinesh/Desktop/testExcel.xls");
    FileInputStream inputStream = new FileInputStream(file);

    Workbook names = null;

    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    if(fileExtensionName.equals(".xlsx")){
    names = new XSSFWorkbook(inputStream);
    }

    else if(fileExtensionName.equals(".xls")){
        names = new HSSFWorkbook(inputStream);
    }
    Sheet sheet = names.getSheet("namesSheet");
    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
//    System.out.println(sheet.getLastRowNum());
//    System.out.println(sheet.getFirstRowNum());
//    Integer[] a=new Integer[0];
    for (int i = 1; i < 7; i++) {
        Row row = sheet.getRow(i);
//        for (int j = 0; j < row.getLastCellNum(); j++) {
        	DataFormatter formatter = new DataFormatter();
        	Cell cell = sheet.getRow(i).getCell(0);
        	 String keyValue = formatter.formatCellValue(cell);
        	 if(keyValue.equals("Microsoft SCOM")){
        		 int rowvalue=i;
        		 for(int columnvalue=1;columnvalue<row.getLastCellNum();columnvalue++){
        			 Cell columnValue=sheet.getRow(0).getCell(columnvalue);
        			 Cell value = sheet.getRow(rowvalue).getCell(columnvalue);
        			 String heading = formatter.formatCellValue(columnValue);
        			 String actValue=formatter.formatCellValue(value);
        			 
        			 System.out.println(columnValue);
        			 System.out.println(value);
        			 if(heading.equals("Collectors/Groups")||heading.equals("SSL Config")||heading.equals("Auto Discovery")||heading.equals("Max Events")){
        				 WebElement wait1 = (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//td//tr[descendant::td[contains(.,"+heading+")]]//input[@type='text']")));
        				  WebElement collectorNameClick=driver.findElement(By.xpath("//tr//td//tr[descendant::td[contains(.,"+heading+")]]//input[@type='text']"));
        				  collectorNameClick.clear();
        				  collectorNameClick.sendKeys(actValue);
        			 }
        			 else if(!"".equals(actValue)){
        				 WebElement instanceName = driver.findElement(By.xpath("//tr[descendant::td[contains(.,"+heading+")]]//input[@type='text']"));		
        				  instanceName.clear();
        				  instanceName.sendKeys(actValue);
        			 }
        			 if(!"".equals(actValue)){
        				 WebElement instanceName = driver.findElement(By.xpath("//tr[descendant::td[contains(.,"+heading+")]]//input[@type='text']"));		
        				  instanceName.clear();
        				  instanceName.sendKeys(actValue);
        			 }
        		 }
        		 
        	 }
//            System.out.print(value+"|| ");
            //row.getCell(j).getStringCellValue()
//        }
        System.out.println();
    }
    
    }


    public static void main(String[] args) throws IOException{

    excelTest objExcelFile = new excelTest();

    String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";

    objExcelFile.readExcel(filePath,"testExcel.xls","namesSheet");

    }

}