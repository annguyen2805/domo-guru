import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


WebUI.waitForPageLoad(3)
CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByName'('uid'), GlobalVariable.username)
CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByType'('password'), GlobalVariable.password)
WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

