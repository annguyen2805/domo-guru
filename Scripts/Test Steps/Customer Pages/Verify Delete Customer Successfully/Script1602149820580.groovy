import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




WebUI.waitForAlert(5)

if (WebUI.verifyMatch(WebUI.getAlertText(), 'Customer deleted Successfully', false)) {
	println('Deleted')
	WebUI.delay(3)
	WebUI.acceptAlert()
}

CustomKeywords.'common.clickMainOptions'('Edit Customer')

WebUI.waitForPageLoad(5)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('cusid'), customerID)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

WebUI.waitForAlert(3)

if(WebUI.verifyMatch(WebUI.getAlertText(), 'Customer does not exist!!', false))
{
	WebUI.delay(3)
	println("Deleting in excel")
	CustomKeywords.'common.deleteCustomerID'(Integer.parseInt(customerID))
	WebUI.acceptAlert()
	
}
