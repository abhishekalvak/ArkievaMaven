package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * THis is a generic class for data driven testing
 * @author ABHISHEK ALVA K
 */
public class FileLib {
	/**
	 *THis is generic method for reading data from property file
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
 public String getPropertData(String key) throws IOException
 {
	 FileInputStream fis=new FileInputStream("./data/commondata.property");
	 Properties p=new Properties();
	 p.load(fis);
	 String value=p.getProperty(key);
	 return value;
	
	}
 /**
  * THis is generic method for reading data from Excel file
  * 
  * @param Sheet
  * @param Row
  * @param Cell
  * @return
  * @throws EncryptedDocumentException
  * @throws IOException
  */
 public String getExcelData(String Sheet,int Row,int Cell) throws EncryptedDocumentException, IOException
 {
	 FileInputStream fis2=new FileInputStream("./data/Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fis2);
		String cell_value=wb.getSheet(Sheet).getRow(Row).getCell(Cell).getStringCellValue();
		return cell_value;
 }
 
 public void setExcelData(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException
 {
	 FileInputStream fis=new FileInputStream("./data/Book2.xlsx");
	 Workbook wb=WorkbookFactory.create(fis);
	 wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
	 FileOutputStream fos=new FileOutputStream("./data/Book2.xlsx");
	 wb.write(fos);
 }

}
