import java.text.SimpleDateFormat

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'common.clickMainOptions'('New Customer')

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('name'), name)

WebUI.click(CustomKeywords.'common.inputFieldByValue'(gender)) //m or f

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('dob'), dOB)

WebUI.sendKeys(CustomKeywords.'common.textAreaByName'('addr'), address)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('city'), city)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('state'), state)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('pinno'), pin)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('telephoneno'), phone)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('emailid'), mail)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('password'), pass)

WebUI.delay(1)
WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))
WebUI.delay(1)
WebUI.waitForElementPresent(CustomKeywords.'common.outputObject'('Customer ID'), 2)

int customerID = Integer.parseInt(WebUI.getText(CustomKeywords.'common.outputObject'('Customer ID')))

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


println customerID
return customerID.toString()
//CustomKeywords.'common.updateCustomerID'(customerID, Integer.parseInt(pin))



