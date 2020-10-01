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

CustomKeywords.'common.clickMainOptions'('Delete Account')

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('accountno'), accountID)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

WebUI.waitForAlert(5)

WebUI.acceptAlert()

WebUI.waitForAlert(5)

if (WebUI.verifyMatch(WebUI.getAlertText(), 'Account Deleted Sucessfully', false)) {
    println('Deleted')

    WebUI.acceptAlert()
}


WebUI.callTestCase(findTestCase('Folder_02_Create_And_Edit_Account/TC04_Check Delete Account'), [('accountID') : accountID], 
    FailureHandling.STOP_ON_FAILURE)

