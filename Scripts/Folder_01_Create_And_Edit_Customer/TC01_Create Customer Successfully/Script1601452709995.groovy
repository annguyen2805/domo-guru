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
import com.kms.katalon.core.util.KeywordUtil
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

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('emailid'), mail)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('password'), pass)

WebUI.delay(1)
WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))
WebUI.delay(1)
WebUI.waitForElementPresent(CustomKeywords.'common.outputObject'('Customer ID'), 2)

int customerID = Integer.parseInt(WebUI.getText(CustomKeywords.'common.outputObject'('Customer ID')))

WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Customer Name')), name, false)  
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Address')), address, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('City')), city, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('State')), state, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Pin')), pin, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Mobile No.')), phone, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Email')), mail, false)

if(WebUI.getText(CustomKeywords.'common.outputObject'('Gender')).startsWith(gender))
{
	KeywordUtil.markPassed("Matched")
}

// input and output in different formats 			WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Birthdate')), dOB, false)

println customerID

CustomKeywords.'common.updateCustomerID'(customerID, Integer.parseInt(pin))



