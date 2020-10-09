import java.text.SimpleDateFormat

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.waitForElementPresent(CustomKeywords.'common.outputObject'('Customer ID'), 2)



WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Customer Name')), name, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Address')), address, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('City')), city, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('State')), state, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Pin')), pin, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Mobile No.')), phone, false)
WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Email')), mail, false)

//Compare Gender
if(WebUI.getText(CustomKeywords.'common.outputObject'('Gender')).startsWith(gender))
{
	KeywordUtil.markPassed("Gender Matched")
}

//Compare date of birth
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm/dd/yyyy")
Date date = simpleDateFormat.parse(dOB)
simpleDateFormat.applyPattern("yyyy-mm-dd")
String newDOB = simpleDateFormat.format(date)

WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Birthdate')), newDOB, false,FailureHandling.CONTINUE_ON_FAILURE)