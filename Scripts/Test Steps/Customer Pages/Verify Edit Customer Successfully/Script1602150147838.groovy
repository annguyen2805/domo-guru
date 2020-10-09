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

WebUI.delay(3)

try {
	if (WebUI.getAlertText().equalsIgnoreCase('No Changes made to Customer records')) {
		WebUI.acceptAlert()

		println('No change alert accepted')
	}
}
catch (Exception e) {
	WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Customer details updated Successfully!!!'))

	println('Edit successfully')

	CustomKeywords.'common.updateCustomerInfo'(Integer.parseInt(customerID))

	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Address')), address, false)

	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('City')), city, false)

	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('State')), state, false)

	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Pin')), pin, false)

	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Mobile No.')), phone, false)

	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Email')), mail, false)
}