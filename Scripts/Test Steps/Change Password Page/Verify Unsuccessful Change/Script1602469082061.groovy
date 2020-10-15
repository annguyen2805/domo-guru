import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable



try{
	WebUI.verifyMatch(WebUI.getAlertText(), expectedMessage, false)
	WebUI.delay(GlobalVariable.timeOut)
}
catch(Exception e)
{
	WebUI.verifyMatch(WebUI.getAlertText().toLowerCase(), 'please fill all fields', false)
	WebUI.delay(GlobalVariable.timeOut)
	WebUI.acceptAlert()
	if(WebUI.verifyMatch(CustomKeywords.'common.getMessageText'(id.toString()), expectedMessage, false))
	{
		KeywordUtil.markPassed('Pass')
		
	}
		
	
}
