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

WebUI.callTestCase(findTestCase("Common/TC01_Login Successfully") ,null)

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'New Customer']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Edit Customer']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'New Account']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Edit Account']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Delete Account']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Deposit']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Withdrawal']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Fund Transfer']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Change Password']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Balance Enquiry']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Mini Statement']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Customised Statement']))

WebUI.click(findTestObject('Common Objects/MainOption',['optionName':'Log out']))
