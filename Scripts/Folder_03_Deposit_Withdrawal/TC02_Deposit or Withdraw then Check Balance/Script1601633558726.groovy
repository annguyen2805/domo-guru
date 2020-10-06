import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'common.clickMainOptions'(type)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('accountno'), accountID)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('ammount'), amount)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('desc'), description)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

if(type.toString().equalsIgnoreCase("Deposit"))
{
	WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Transaction details of Deposit for Account '+ accountID))
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account No')), accountID, false)
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Amount Credited')), amount, false)
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Type of Transaction')), type, false)
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Description')), description, false)
	
}
else if(type.toString().equalsIgnoreCase("Withdrawal"))
{
	WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Transaction details of Withdrawal for Account '+accountID))
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account No')), accountID, false)
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Amount Debited')), amount, false)
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Type of Transaction')), type, false)
	
	WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Description')), description, false)
}


String currentBalance = WebUI.getText(CustomKeywords.'common.outputObject'('Current Balance'))

WebUI.callTestCase(findTestCase('Folder_04_Balance Enquiry/TC01_Check Balance'), [('accountID') : accountID
		, ('expectedBalance') : currentBalance], FailureHandling.STOP_ON_FAILURE)

