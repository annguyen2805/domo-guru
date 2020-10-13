import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.waitForElementClickable(findTestObject('Object Repository/Common Objects/MainOption', [('optionName') : 'Edit Account']), 
    10)

CustomKeywords.'common.clickMainOptions'('Edit Account')

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('accountno'), accountID)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

WebUI.selectOptionByValue(CustomKeywords.'common.selectByName'('a_type'), accountType_edit, false)

WebUI.click(CustomKeywords.'common.inputFieldByType'('Submit'))



