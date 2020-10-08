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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.lang.String
import org.openqa.selenium.By as By

public class common {
	String basePath = new File("").getAbsolutePath();
	@Keyword
	public static String randomPassword() {

		Random random = new Random()
		return 'duy@'+ random.nextInt(9999).toString()
	}
	@Keyword
	String randomEmail(){
		Random random = new Random()
		return 'apon'+ random.nextInt(9999).toString() +'@gmail.com'
	}
	@Keyword
	public void updatePassword(String text) {
		FileInputStream file = new FileInputStream(new File(basePath +"/Excels/Credentials.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		'Read data from excel'
		String Data_fromCell=sheet.getRow(1).getCell(1).getStringCellValue();
		'Write data to excel'
		sheet.getRow(1).createCell(1).setCellValue(text);

		file.close();
		FileOutputStream outFile =new FileOutputStream(new File(basePath +"/Excels/Credentials.xlsx"));
		workbook.write(outFile);
		outFile.close();
	}
	@Keyword
	public void updateCustomerID(int text, int pin) {
		FileInputStream file = new FileInputStream(new File(basePath+'/Excels/CreateCustomer.xlsx'));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		'Read data from excel'

		'Write data to excel'
		for(int i=1; i<= sheet.getLastRowNum();i++) {
			int customerPIN = (Integer)sheet.getRow(i).getCell(6).getNumericCellValue();
			if(customerPIN == pin) {
				sheet.getRow(i).createCell(10).setCellValue(text);
			}
		}
		file.close();
		FileOutputStream outFile =new FileOutputStream(new File(basePath +'/Excels/CreateCustomer.xlsx'));
		workbook.write(outFile);
		outFile.close();
	}
	@Keyword
	public void updateCustomerInfo(int customerID) {
		FileInputStream customerFile = new FileInputStream(new File(basePath +'/Excels/CreateCustomer.xlsx'));
		XSSFWorkbook workbook1 = new XSSFWorkbook(customerFile);
		XSSFSheet sheet1 = workbook1.getSheetAt(0);

		FileInputStream editFile = new FileInputStream(new File(basePath +'/Excels/EditCustomer.xlsx'));
		XSSFWorkbook workbook2 = new XSSFWorkbook(editFile);
		XSSFSheet sheet2 = workbook2.getSheetAt(0);

		'Read data from excel'
		'Write data to excel'
		for(int i=1; i <= sheet1.getLastRowNum();i++) {
			if(sheet1.getRow(i).getCell(10).getNumericCellValue() == customerID) {

				for(int j=1;j<=sheet2.getLastRowNum();j++) {
					if(sheet2.getRow(j).getCell(0).getNumericCellValue() == customerID) {
						String address = sheet2.getRow(j).getCell(1).getStringCellValue();

						String city = sheet2.getRow(j).getCell(2).getStringCellValue();

						String state = sheet2.getRow(j).getCell(3).getStringCellValue();

						String pin = (Integer) sheet2.getRow(j).getCell(4).getNumericCellValue();

						String phone = (Integer) sheet2.getRow(j).getCell(5).getNumericCellValue();

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
		FileOutputStream outFile = new FileOutputStream(new File(basePath +'/Excels/CreateCustomer.xlsx'));
		workbook1.write(outFile);
		outFile.close();
	}

	@Keyword
	public void updateAccountInfo(int accountID){
		FileInputStream accountFile = new FileInputStream(new File(basePath +'/Excels/CreateNewAccount.xlsx'));
		XSSFWorkbook workbook1 = new XSSFWorkbook(accountFile);
		XSSFSheet sheet1 = workbook1.getSheetAt(0);

		FileInputStream editFile = new FileInputStream(new File(basePath +'/Excels/EditAccount.xlsx'));
		XSSFWorkbook workbook2 = new XSSFWorkbook(editFile);
		XSSFSheet sheet2 = workbook2.getSheetAt(0);

		for(int i = 1; i < sheet1.getLastRowNum(); i++) {
			if(sheet1.getRow(i).getCell(3).getNumericCellValue() == accountID) {
				for(int j = 1; j < sheet2.getLastRowNum(); j++) {
					if(sheet2.getRow(j).getCell(0).getNumericCellValue() == accountID) {
						String accountType = sheet2.getRow(j).getCell(1).getStringCellValue();

						sheet1.getRow(i).getCell(1).setCellValue(accountType);
					}
				}
			}
		}
		accountFile.close();
		editFile.close();
		FileOutputStream outFile = new FileOutputStream(new File(basePath +'/Excels/CreateNewAccount.xlsx'));
		workbook1.write(outFile);
		outFile.close();
	}



	@Keyword
	public void updateAccountID(int text, int iniDeposit) {
		FileInputStream file = new FileInputStream(new File(basePath +'/Excels/CreateNewAccount.xlsx'));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		'Write data to excel'
		for(int i=1; i<= sheet.getLastRowNum();i++) {
			int deposit = (Integer)sheet.getRow(i).getCell(2).getNumericCellValue();
			if(deposit == iniDeposit) {
				if(sheet.getRow(i).getCell(3) == null) {
					sheet.getRow(i).createCell(3).setCellValue(text);
					break;
				}
				else if(sheet.getRow(i).getCell(3).getNumericCellValue() == 0) {
					sheet.getRow(i).createCell(3).setCellValue(text);
					break;
				}
			}
		}
		file.close();
		FileOutputStream outFile =new FileOutputStream(new File(basePath +'/Excels/CreateNewAccount.xlsx'));
		workbook.write(outFile);
		outFile.close();
	}
	@Keyword
	public void deleteAccountID(int accountID) {
		FileInputStream file = new FileInputStream(new File(basePath +'/Excels/CreateNewAccount.xlsx'));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		'Write data to excel'
		for(int i=1; i<= sheet.getLastRowNum();i++) {
			if(sheet.getRow(i).getCell(3).getNumericCellValue() == accountID) {
				sheet.getRow(i).getCell(3).setCellValue(null);
			}
		}
		file.close();
		FileOutputStream outFile =new FileOutputStream(new File(basePath +'/Excels/CreateNewAccount.xlsx'));
		workbook.write(outFile);
		outFile.close();
	}
	@Keyword
	public void deleteCustomerID(int customerID) {
		FileInputStream file = new FileInputStream(new File(basePath +'/Excels/CreateCustomer.xlsx'));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		'Write data to excel'
		for(int i=1; i<= sheet.getLastRowNum();i++) {
			if(sheet.getRow(i).getCell(10).getNumericCellValue() == customerID) {
				sheet.getRow(i).getCell(10).setCellValue(null);
			}
		}
		file.close();
		FileOutputStream outFile =new FileOutputStream(new File(basePath +'/Excels/CreateCustomer.xlsx'));
		workbook.write(outFile);
		outFile.close();
	}
	@Keyword
	public boolean verifyTableCell(String colName, String expectedData,String tableID) {
		WebDriver driver = DriverFactory.getWebDriver();
		WebElement table = driver.findElement(By.xpath('//table[@id="'+tableID+'"]/tbody'));
		List<WebElement> rows = table.findElements(By.tagName('tr'));

		'Thay expected Cell thanh colName(e.g:Description) -> tim cot theo first row ->'


		List<WebElement> headers = rows.get(0).findElements(By.tagName('th'));
		for(int i =0; i< headers.size();i++) {
			if(headers.get(i).getText().equalsIgnoreCase(colName)) {
				for(int j = 1; j< rows.size()-1; j++) {
					List<WebElement> cells = rows.get(j).findElements(By.tagName('td'));
					if(cells.get(i).getText().equalsIgnoreCase(expectedData)) {
						KeywordUtil.markPassed("Data Cell: " + expectedData + " Matched");
						return true;
					}
				}
			}
		}
		KeywordUtil.markFailedAndStop("Data Cell: " + expectedData + " Not matched")
		return false;
	}
	@Keyword
	public boolean verifyTransactionNumber(int expectedNumber, String tableID) {
		WebDriver driver = DriverFactory.getWebDriver();
		WebElement table = driver.findElement(By.xpath('//table[@id="'+tableID+'"]/tbody'));
		List<WebElement> rows = table.findElements(By.tagName('tr'));
		if(expectedNumber == (rows.size()-2)) {
			KeywordUtil.markPassed("Number of transaction verified")
			return true;
		}
		else if(expectedNumber > (rows.size()-2))
		{
			KeywordUtil.markPassed("Number of transaction verified")
			return true;
		}
		KeywordUtil.markFailed("Number of transaction not matched")
		return false
	}
	@Keyword
	public void verifyMinValue(int minValue, String tableID) {
		WebDriver driver = DriverFactory.getWebDriver();
		WebElement table = driver.findElement(By.xpath('//table[@id="'+tableID+'"]/tbody'));
		List<WebElement> rows = table.findElements(By.tagName('tr'));
		int rowSize = rows.size();
		for(int i=1; i< rowSize - 1;i++ ) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName('td'));

			println(cells.size())

			if(Integer.parseInt(cells.get(0).getText()) < minValue ) {

				KeywordUtil.markFailed("Min amount not verified")
				return;
			}
		}
		KeywordUtil.markPassed("Min amount verified")
	}


	@Keyword
	def clickMainOptions(String optionName) {
		WebUI.verifyElementClickable(findTestObject('Common Objects/MainOption', ['optionName' : optionName]))
		WebUI.click(findTestObject('Common Objects/MainOption', ['optionName' : optionName]))
		WebUI.waitForPageLoad(2)
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
	@Keyword
	TestObject outputObject(String outputName){
		return findTestObject('Object Repository/Common Objects/outputObject',['outputName':outputName])
	}
	@Keyword
	TestObject selectByName(String selectName) {
		return findTestObject('Object Repository/Common Input Fields/SelectByName',['selectName': selectName])
	}
	@Keyword
	TestObject messageNoti(String messageContent) {
		return findTestObject('Object Repository/Common Objects/NotificationMessage',['messageContent': messageContent])
	}
}
