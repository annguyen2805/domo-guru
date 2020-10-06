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

CustomKeywords.'common.clickMainOptions'('Fund Transfer')

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('payersaccount'), payerAccount)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('payeeaccount'), payeeAccount)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('ammount'), amount)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('desc'), description)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Fund Transfer Details'))

WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('From Account Number')), payerAccount, false)

WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('To Account Number')), payeeAccount, false)

WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Amount')), amount, false)

WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Description')), description, false)


WebUI.callTestCase(findTestCase('Folder_06_Check Mini Statement/TC01_Check Mini Statement After Transfer'), [('accountID') : payerAccount
        , ('payeeAccount') : payeeAccount, ('amount') : amount, ('description') : description], 
    FailureHandling.STOP_ON_FAILURE)

