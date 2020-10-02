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


WebUI.refresh()

WebUI.waitForElementClickable(findTestObject('Object Repository/Common Objects/MainOption',['optionName' : 'Edit Account']), 10)

CustomKeywords.'common.clickMainOptions'('Edit Account')

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('accountno'), accountID)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

WebUI.selectOptionByValue(CustomKeywords.'common.selectByName'('a_type'), accountType, false)

WebUI.click(CustomKeywords.'common.inputFieldByType'('Submit'))

try {
	WebUI.waitForAlert(3)
	if (WebUI.getAlertText().equalsIgnoreCase('No Changes made to Account records')) {
		WebUI.acceptAlert()
		println('No change alert accepted')
		
		
	}
}
catch (Exception e) {
	WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Account details updated Successfully!!!'))
	println('Edit successfully')
	CustomKeywords.'common.updateAccountInfo'(Integer.parseInt(accountID))
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account ID')), accountID, false)
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account Type')), accountType, false)
}







