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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'common.clickMainOptions'('New Account')

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('cusid'), customerID)

WebUI.selectOptionByValue(CustomKeywords.'common.selectByName'('selaccount'), accountType, false)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('inideposit'), iniDeposit)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

WebUI.delay(3)

WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Account Generated Successfully!!!'))

int accountID = Integer.parseInt(WebUI.getText(CustomKeywords.'common.outputObject'('Account ID')))

println(accountID)

CustomKeywords.'common.updateAccountID'(accountID, Integer.parseInt(iniDeposit))

WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Customer ID')), customerID, false)

WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account Type')), accountType, false)

WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Current Amount')), iniDeposit, false)