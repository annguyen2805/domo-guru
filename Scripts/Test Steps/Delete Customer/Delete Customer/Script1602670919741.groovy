import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



CustomKeywords.'common.clickMainOptions'('Delete Customer')

CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByName'('cusid'), customerID)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

WebUI.waitForAlert(5)

if(WebUI.verifyMatch(WebUI.getAlertText(), 'Do you really want to delete this Customer?', false, FailureHandling.STOP_ON_FAILURE))
{
	WebUI.delay(3)
	WebUI.acceptAlert()
}
