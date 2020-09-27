import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.junit.After as After
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Common Test Case/Login Successful'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('NewCustomerPageUI/Page_Guru99 Bank Manager HomePage/a_New Customer'))

List<WebElement> listElements = DriverFactory.getWebDriver().findElements(By.xpath('//tr//td[2]//input'))

//int size = listElements.size()
listElements.get(0).sendKeys('Nem Nui')

listElements.get(1).click()

listElements.get(3).sendKeys('10/11/1988')

listElements.get(4).sendKeys('Hoang Quoc Viet')

listElements.get(5).sendKeys('Ha Noi')

listElements.get(6).sendKeys('111111')

listElements.get(7).sendKeys('0815957400')

listElements.get(8).sendKeys('anhnem08@gmail.com')

listElements.get(9).sendKeys('123456')

WebElement address = DriverFactory.getWebDriver().findElement(By.xpath('//table[@class=\'layout\']//textarea'))

address.sendKeys('60 Hoang Quoc Viet')

listElements.get(10).click()

WebElement getTextCU = DriverFactory.getWebDriver().findElement(By.xpath('//*[@id="customer"]//p'))

String getTextLogin = getTextCU.getText()

WebUI.verifyEqual(getTextLogin, 'Customer Registered Successfully!!!')

WebUI.closeBrowser()

