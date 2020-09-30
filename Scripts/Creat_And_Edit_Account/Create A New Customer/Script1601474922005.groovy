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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common Test Case/Login Successful'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('NewCustomerPageUI/Page_Guru99 Bank Manager HomePage/a_New Customer'))

WebUI.sendKeys(findTestObject('CommonInputField/TextField'), 'name', name)

WebUI.click(findTestObject('CommonInputField/TextField'), 'gender')

WebUI.sendKeys(findTestObject('CommonInputField/TextField'), 'dob', dob)

WebUI.sendKeys(findTestObject('CommonInputField/TextField'), 'addr', address)

WebUI.sendKeys(findTestObject('CommonInputField/TextField'), 'city', city)

WebUI.sendKeys(findTestObject('CommonInputField/TextField'), 'state', state)

WebUI.sendKeys(findTestObject('CommonInputField/TextField'), 'pinno', PIN)

WebUI.sendKeys(findTestObject('CommonInputField/TextField'), 'telephoneno', telephoneNumber)

WebUI.sendKeys(findTestObject('CommonInputField/TextField'), 'emailid', email)

WebUI.sendKeys(findTestObject('CommonInputField/TextField'), 'submit', password)

