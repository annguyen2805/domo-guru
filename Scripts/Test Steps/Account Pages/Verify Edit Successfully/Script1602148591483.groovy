import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


try {
	WebUI.waitForAlert(3)

	if (WebUI.getAlertText().equalsIgnoreCase('No Changes made to Account records')) {
		WebUI.acceptAlert()

		println('No change alert accepted')
	}
}
catch (Exception e) {
	WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Account details updated Successfully!!!'))
	
	//CustomKeywords.'common.updateAccountInfo'(Integer.parseInt(accountID))
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account ID')), accountID, false)
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account Type')), accountType_edit, false)
	
	KeywordUtil.markPassed('Edit successfully')
}


