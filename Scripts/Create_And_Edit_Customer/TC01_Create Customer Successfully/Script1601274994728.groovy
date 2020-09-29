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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'common.clickMainOptions'('New Customer')

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('name'), name)

WebUI.click(CustomKeywords.'common.inputFieldByValue'(gender)) //m or f

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('dob'), dOB)

WebUI.sendKeys(CustomKeywords.'common.textAreaByName'('addr'), address)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('city'), city)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('state'), state)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('pinno'), pin)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('telephoneno'), phone)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('emailid'), CustomKeywords.'common.randomEmail'())

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('password'), pass)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NewCustomerPageUI/CustomerID'), 0)

String customerID = WebUI.getText(findTestObject('Object Repository/NewCustomerPageUI/CustomerID')) 

println customerID

CustomKeywords.'common.updateCustomerID'(customerID)


