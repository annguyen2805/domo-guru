import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.String

public class common {
	
	@Keyword
	String randomPassword() {
		
		Random random = new Random()
		return 'duy@'+ random.nextInt(9999).toString()
	}
	@Keyword
	String randomEmail(){
		Random random = new Random()
		return 'apon'+ random.nextInt(9999).toString() +'@gmail.com'
	}
	@Keyword
	public static void updatePassword(String text) {
		FileInputStream file = new FileInputStream(new File('D:\\Excels\\Credentials.xlsx'));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		'Read data from excel'
		String Data_fromCell=sheet.getRow(1).getCell(1).getStringCellValue();
		'Write data to excel'
		sheet.getRow(1).createCell(1).setCellValue(text);

		file.close();
		FileOutputStream outFile =new FileOutputStream(new File('D:\\Excels\\Credentials.xlsx'));
		workbook.write(outFile);
		outFile.close();
	}
	@Keyword
	public static void updateCustomerID(String text) {
		FileInputStream file = new FileInputStream(new File('D:\\Excels\\CreateCustomer.xlsx'));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		'Read data from excel'
		String Data_fromCell=sheet.getRow(1).getCell(1).getStringCellValue();
		'Write data to excel'
		sheet.getRow(1).createCell(10).setCellValue(text);

		file.close();
		FileOutputStream outFile =new FileOutputStream(new File('D:\\Excels\\CreateCustomer.xlsx'));
		workbook.write(outFile);
		outFile.close();
	}
	@Keyword
	public static void updateCustomerInfo(String customerID) {
		FileInputStream customerFile = new FileInputStream(new File('D:\\Excels\\CreateCustomer.xlsx'));
		XSSFWorkbook workbook1 = new XSSFWorkbook(customerFile);
		XSSFSheet sheet1 = workbook1.getSheetAt(0);

		FileInputStream editFile = new FileInputStream(new File('D:\\Excels\\EditCustomer.xlsx'));
		XSSFWorkbook workbook2 = new XSSFWorkbook(editFile);
		XSSFSheet sheet2 = workbook2.getSheetAt(0);

		'Read data from excel'
		'Write data to excel'
		for(int i=1; i <= sheet1.getLastRowNum();i++) {
			if(sheet1.getRow(i).getCell(10).getStringCellValue().equalsIgnoreCase(customerID)) {
				for(int j=1;j<=sheet2.getLastRowNum();j++) {
					if(sheet2.getRow(j).getCell(0).getStringCellValue().equalsIgnoreCase(customerID)) {
						String address = sheet2.getRow(j).getCell(1).getStringCellValue();
						String city = sheet2.getRow(j).getCell(2).getStringCellValue();
						String state = sheet2.getRow(j).getCell(3).getStringCellValue();
						String pin = sheet2.getRow(j).getCell(4).getStringCellValue();
						String phone = sheet2.getRow(j).getCell(5).getStringCellValue();
						String mail = sheet2.getRow(j).getCell(6).getStringCellValue();

						sheet1.getRow(i).createCell(3).setCellValue(address);
						sheet1.getRow(i).createCell(4).setCellValue(city);
						sheet1.getRow(i).createCell(5).setCellValue(state);
						sheet1.getRow(i).createCell(6).setCellValue(pin);
						sheet1.getRow(i).createCell(7).setCellValue(phone);
						sheet1.getRow(i).createCell(8).setCellValue(mail);
					}
				}
			}
		}
		customerFile.close();
		editFile.close();
		FileOutputStream outFile = new FileOutputStream(new File('D:\\Excels\\CreateCustomer.xlsx'));
		workbook1.write(outFile);
		outFile.close();
	}


	@Keyword
	def clickMainOptions(String optionName) {
		WebUI.click(findTestObject('Common Objects/MainOption', ['optionName' : optionName]))
	}

	@Keyword
	TestObject inputFieldByName(String nameValue) {
		return findTestObject('Common Input Fields/InputFieldByName',['inputName': nameValue])
	}

	@Keyword
	TestObject inputFieldByType(String typeValue) {
		return findTestObject('Common Input Fields/InputFieldByType',['inputType': typeValue])
	}

	@Keyword
	TestObject inputFieldByValue(String value) {
		return findTestObject('Common Input Fields/InputFieldByValue',['inputValue': value])
	}
	@Keyword
	TestObject textAreaByName(String nameValue) {
		return findTestObject('Object Repository/Common Input Fields/TextAreaByName',['nameValue':nameValue])
	}
}
