import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


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
	
	CustomKeywords.'common.updateAccountInfo'(Integer.parseInt(accountID))
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account ID')), accountID, false)
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account Type')), accountType, false)
	
	KeywordUtil.markPassed('Edit successfully')
}







