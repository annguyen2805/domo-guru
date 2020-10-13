import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
WebUI.waitForAlert(4)
try{
	WebUI.verifyMatch(WebUI.getAlertText(), expectedMessage, false)
}
catch(Exception e)
{
	WebUI.verifyMatch(WebUI.getAlertText().toLowerCase(), 'please fill all fields', false)
	
	WebUI.acceptAlert()
	if(WebUI.verifyMatch(CustomKeywords.'common.getMessageText'(id.toString()), expectedMessage, false))
	{
		KeywordUtil.markPassed('Pass')
		
	}
}